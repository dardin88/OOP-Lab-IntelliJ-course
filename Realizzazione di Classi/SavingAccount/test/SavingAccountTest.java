import org.junit.Assert;
import org.junit.Test;

public class SavingAccountTest {
    @Test
    public void depositAndWithDrawTest() {
        SavingAccount harrysChecking = new SavingAccount(1);
        harrysChecking.deposit(2000);
        harrysChecking.withdraw(500);
        Assert.assertEquals(1500, harrysChecking.getBalance(), 0);
    }

    @Test
    public void interestComputationTest() {
        SavingAccount harrysChecking = new SavingAccount(1000, 1);
        harrysChecking.addInterest();
        Assert.assertEquals(1002.5, harrysChecking.getBalance(), 0);
    }

    @Test
    public void setAndGetInterestsTest() {
        SavingAccount harrysChecking = new SavingAccount(1000, 1);
        harrysChecking.setInterestRate(2);
        Assert.assertEquals(2, harrysChecking.getInterestRate(), 0);
        harrysChecking.addInterest();
        Assert.assertEquals(1005, harrysChecking.getBalance(), 0);
    }

}