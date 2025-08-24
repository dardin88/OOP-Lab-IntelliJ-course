package it.unisa.supermarket;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class ProductTest {

    @Test
    public void putOnSale() {
        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
    electronic1.putOnSale(10, LocalDate.of(2022, 10, 30));
        Assert.assertEquals(720, electronic1.getPrice(), 0);
    }

    @Test
    public void checkOnSale() {
        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
    electronic1.putOnSale(10, LocalDate.of(2022, 10, 30));
        electronic1.checkOnSale();
        Assert.assertEquals(800, electronic1.getPrice(), 0);
    }
}