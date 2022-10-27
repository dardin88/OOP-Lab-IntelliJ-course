package it.unisa.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}