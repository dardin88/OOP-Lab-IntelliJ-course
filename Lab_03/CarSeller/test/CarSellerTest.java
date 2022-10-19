import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
}