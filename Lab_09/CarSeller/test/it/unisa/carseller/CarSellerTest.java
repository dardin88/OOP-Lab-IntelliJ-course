package it.unisa.carseller;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.util.List;

public class CarSellerTest {
    @Test
    public void returnCarByBrandAndModelTest() {
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            carSeller.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Car> suitableCars = carSeller.returnCarByBrandAndModel("Tesla", "Model Y");
        Assert.assertEquals(2, suitableCars.size());
    }

    @Test
    public void returnCarByBrandModelAndYearTest() {
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            carSeller.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Car> suitableCars = carSeller.returnCarByBrandModelAndYear("Tesla", "Model Y", 2022);
        Assert.assertEquals(1, suitableCars.size());
    }

    @Test
    public void returnCarByBrandAModelYearAndPriceTest() {
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            carSeller.readUserDataFromFile(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Car> suitableCars = carSeller.returnCarByBrandAModelYearAndPrice("Tesla", "Model Y", 2022, 1000, 5000);
        Assert.assertEquals(0, suitableCars.size());
    }

    @Test
    public void writeUserDataToFileTest() {
        CarSeller carSeller = new CarSeller();
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            //Read the file, change the price of the first car, and save it
            carSeller.readUserDataFromFile(file);
            carSeller.getCars().getFirst().setPrice(40000);
            carSeller.writeUserDataToFile(file, true);

            //Read the file to assert that it was correctly written
            carSeller.readUserDataFromFile(file);
            Assert.assertEquals(40000, carSeller.getCars().getFirst().getPrice(), 0);

            //Restore the original price
            carSeller.getCars().getFirst().setPrice(35000);
            carSeller.writeUserDataToFile(file, true);
        } catch (FileNotFoundException | FileAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeSerializedDataToFileTest() {
        CarSeller carSeller = new CarSeller();
        CarSeller carSeller2 = new CarSeller();
        File textFile = Path.of("test/").resolve("testData.txt").toFile();
        File binFile = new File("test/testData.dat");
        try {
            //Read the data from the text file and save them in the bin file
            carSeller.readUserDataFromFile(textFile);
            carSeller.writeSerializedDataToFile(binFile);

            //The data is read from the binary file and the number of cars is verified
            carSeller2.readSerializedDataFromFile(binFile);
            Assert.assertEquals(4, carSeller2.getCars().size());

            //Finally the binary file is removed
            binFile.delete();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}