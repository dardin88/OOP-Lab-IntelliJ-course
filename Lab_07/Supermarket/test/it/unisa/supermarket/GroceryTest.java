package it.unisa.supermarket;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GroceryTest {

    @Test
    public void buy1() {
        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        Assert.assertTrue(grocery1.buy(200));
    }

    @Test
    public void buy2() {
        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        Assert.assertFalse(grocery1.buy(400));
    }
}