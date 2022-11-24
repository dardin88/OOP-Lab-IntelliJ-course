package it.unisa.financialhistory;

import org.junit.Assert;
import org.junit.Test;

public class FinancialHistoryTest {

    @Test(expected = IllegalArgumentException.class)
    public void createAccountWithNegativeBalanceTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        new FinancialHistory(p, -100);
    }

    @Test
    public void receiveFromTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        FinancialHistory fh = new FinancialHistory(p, 1000);
        fh.receiveFrom(1000, "Stipendio");
        Assert.assertEquals(2000, fh.cashOnHand(), 0);
    }

    @Test
    public void spendForTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        FinancialHistory fh = new FinancialHistory(p, 1000);
        fh.spendFor(-400, "Affitto");
        Assert.assertEquals(600, fh.cashOnHand(), 0);
    }

    @Test
    public void totalReceivedFrom() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        FinancialHistory fh = new FinancialHistory(p, 1000);
        fh.receiveFrom(1000, "Stipendio");
        fh.receiveFrom(20, "Biglietto lotteria");
        fh.receiveFrom(1000, "Stipendio");
        Assert.assertEquals(2000, fh.totalReceivedFrom("Stipendio"), 0);
    }

    @Test
    public void totalSpentFor() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        FinancialHistory fh = new FinancialHistory(p, 1000);
        fh.receiveFrom(1000, "Stipendio");
        fh.spendFor(-400, "Affitto");
        fh.receiveFrom(1000, "Stipendio");
        fh.spendFor(-400, "Affitto");
        Assert.assertEquals(-800, fh.totalSpentFor("Affitto"), 0);
    }
}
