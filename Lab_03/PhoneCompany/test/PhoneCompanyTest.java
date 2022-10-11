import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
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
}