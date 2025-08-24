package it.unisa.supermarket;

import org.junit.Assert;
import org.junit.Test;

public class ElectronicTest {

    @Test
    public void computeWarrantyPrice() {
        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        Assert.assertEquals(500, electronic1.computeWarrantyPrice(5), 0);
    }

    @Test
    public void buy1() {
        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        Assert.assertTrue(electronic1.buy(2));
    }

    @Test
    public void buy2() {
        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        Assert.assertFalse(electronic1.buy(6));
    }
}