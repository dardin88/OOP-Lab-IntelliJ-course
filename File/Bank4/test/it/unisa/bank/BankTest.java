package it.unisa.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class BankTest {

    @Before
    public void setup() {
        BankAccount.totalNumberOfAccounts = 0;
    }

    @Test
    public void findAccountTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        Assert.assertEquals(1000, newAccount.getBalance(), 0);
        Assert.assertEquals("Harry", newAccount.getCustomerName());
    }

    @Test
    public void depositTest() {
        Bank b = new Bank();
        b.addAccount(new SavingAccount("Harry", 1000, 1));
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        b.deposit(1, 1000);
        Assert.assertEquals(2000, b.getBalance(1), 0);
    }

    @Test
    public void withdrawTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        Assert.assertEquals(1, newAccount.getAccountNumber());
        b.withdraw(1, 200);
        Assert.assertEquals(800, b.getBalance(1), 0);
    }

    @Test
    public void transferTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        b.addAccount(new SavingAccount("Jules", 1000, 1));
        b.transfer(1, 2, 200);
        Assert.assertEquals(800, b.getBalance(1), 0);
        Assert.assertEquals(1200, b.getBalance(2), 0);
    }

    @Test
    public void interestComputationTest() {
        Bank b = new Bank();
        b.addAccount(new SavingAccount("Harry", 1000, 1));
        SavingAccount newAccount = (SavingAccount) b.find(1);
        newAccount.addInterest();
        Assert.assertEquals(1002.5, newAccount.getBalance(), 0);
    }

    @Test
    public void setAndGetInterestsTest() {
        Bank b = new Bank();
        b.addAccount(new SavingAccount("Harry", 1000, 1));
        SavingAccount newAccount = (SavingAccount) b.find(1);
        newAccount.setInterestRate(2);
        Assert.assertEquals(2, newAccount.getInterestRate(), 0);
        newAccount.addInterest();
        Assert.assertEquals(1005, newAccount.getBalance(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bankAccountWithNegativeBalanceTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", -1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalDepositTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        b.deposit(newAccount.getAccountNumber(), -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalWithdrawTest() {
        Bank b = new Bank();
        b.addAccount(new BankAccount("Harry", 1000));
        BankAccount newAccount = b.find(1);
        b.withdraw(newAccount.getAccountNumber(), 1100);
    }


    @Test
    public void writeUserDataToFileTest() throws FileAlreadyExistsException, FileNotFoundException {
        File dataFile = new File("test/testData.txt");

        // Initialize two accounts and save them in a file
        Bank b1 = new Bank();
        b1.addAccount(new BankAccount(1, "Harry", 1000));
        b1.addAccount(new SavingAccount(2, "Jules", 1000, 1));
        b1.writeUserDataToFile(dataFile, true);

        // Read the file and verify the accounts
        Bank b2 = new Bank();
        b2.readUserDataFromFile(new File("test/testData.txt"));
        Assert.assertEquals(2, b2.getAccounts().size());
        Assert.assertEquals("Harry", b2.find(1).getCustomerName());
        SavingAccount julesAccount = (SavingAccount) b2.find(2);
        Assert.assertEquals(1, julesAccount.getInterestRate(), 0);

        dataFile.delete();
    }

    @Test
    public void writeSerializedDataToFileTest() {
        Bank b1 = new Bank();
        Bank b2 = new Bank();
        b1.addAccount(new BankAccount(1, "Harry", 1000));
        b1.addAccount(new SavingAccount(2, "Jules", 1000, 1));

        File binFile = new File("test/testData.dat");
        try {
            //Save the accounts in the bin file
            b1.writeSerializedDataToFile(binFile);

            //The data is read from the binary file and the number of cars is verified
            b2.readSerializedDataFromFile(binFile);
            Assert.assertEquals(2, b2.getAccounts().size());

            //Finally the binary file is removed
            binFile.delete();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}