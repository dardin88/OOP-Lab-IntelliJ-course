package it.unisa.phonecompany;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;

public class PhoneCompanyTest {
    @Test
    public void testSolution() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        try {
            File file = Path.of("test/").resolve("testData.txt").toFile();
            phoneCompany.readUserDataFromFile(file);
            User user1 = phoneCompany.findUserByCode(1);
            phoneCompany.computeUserCost(user1);
            Assert.assertEquals(22.25, user1.getTotalCost(), 0);
            User user2 = phoneCompany.findUserByCode(2);
            phoneCompany.computeUserCost(user2);
            Assert.assertEquals(12.25, user2.getTotalCost(), 0);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeUserDataToFileTest() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        File file = Path.of("test/").resolve("testData.txt").toFile();
        try {
            //Read the file, change the number of used minutes for the first user, and save it
            phoneCompany.readUserDataFromFile(file);
            phoneCompany.getUsers().getFirst().setUsedMinutes(500);
            phoneCompany.writeUserDataToFile(file, true);

            //Read the file to assert that it was correctly written
            phoneCompany.readUserDataFromFile(file);
            Assert.assertEquals(500, phoneCompany.getUsers().getFirst().getUsedMinutes(), 0);

            //Restore the original number of used minutes
            phoneCompany.getUsers().getFirst().setUsedMinutes(200);
            phoneCompany.writeUserDataToFile(file, true);
        } catch (FileNotFoundException | FileAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void writeSerializedDataToFileTest() {
        PhoneCompany phoneCompany = new PhoneCompany(0.10, 0.05, 2);
        PhoneCompany phoneCompany2 = new PhoneCompany(0.10, 0.05, 2);
        File textFile = Path.of("test/").resolve("testData.txt").toFile();
        File binFile = new File("test/testData.dat");
        try {
            //Read the data from the text file and save them in the bin file
            phoneCompany.readUserDataFromFile(textFile);
            phoneCompany.writeSerializedDataToFile(binFile);

            //The data is read from the binary file and the number of cars is verified
            phoneCompany2.readSerializedDataFromFile(binFile);
            Assert.assertEquals(2, phoneCompany2.getUsers().size());

            //Finally the binary file is removed
            binFile.delete();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}