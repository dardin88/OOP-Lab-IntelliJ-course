package it.unisa.supermarket;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SupermarketTest {

    @Test
    public void addProductTest() {
        Supermarket supermarket = new Supermarket();

        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        supermarket.addProduct(grocery1);

        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        supermarket.addProduct(electronic1);

        Grocery grocery2 = new Grocery("G002", "Tonno", "Rio Mare", 3.40, new GregorianCalendar(2024, Calendar.MAY, 7), 270);
        supermarket.addProduct(grocery2);

        Electronic electronic2 = new Electronic("E002", "Cuffie WH-1000XM4", "Sony", 290, 2, 50, 30);
        supermarket.addProduct(electronic2);

        Grocery grocery3 = new Grocery("G003", "Biscotti Grancereale", "Mulino Bianco", 1.50, new GregorianCalendar(2023, Calendar.SEPTEMBER, 23), 200);
        supermarket.addProduct(grocery3);

        Assert.assertEquals(5, supermarket.getProducts().size());
        Assert.assertEquals("E001", supermarket.getProducts().get(0).getCode());
        Assert.assertEquals("G003", supermarket.getProducts().get(4).getCode());
    }

    @Test
    public void getProductTypeTest() {
        Supermarket supermarket = new Supermarket();

        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        supermarket.addProduct(grocery1);

        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        supermarket.addProduct(electronic1);

        Grocery grocery2 = new Grocery("G002", "Tonno", "Rio Mare", 3.40, new GregorianCalendar(2024, Calendar.MAY, 7), 270);
        supermarket.addProduct(grocery2);

        Electronic electronic2 = new Electronic("E002", "Cuffie WH-1000XM4", "Sony", 290, 2, 50, 30);
        supermarket.addProduct(electronic2);

        Grocery grocery3 = new Grocery("G003", "Biscotti Grancereale", "Mulino Bianco", 1.50, new GregorianCalendar(2023, Calendar.SEPTEMBER, 23), 200);
        supermarket.addProduct(grocery3);

        Assert.assertEquals("Electronic", supermarket.getProductType(0));
        Assert.assertEquals("Grocery", supermarket.getProductType(2));
    }

    @Test
    public void getMinPriceTest() {
        Supermarket supermarket = new Supermarket();

        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        supermarket.addProduct(grocery1);

        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        supermarket.addProduct(electronic1);

        Grocery grocery2 = new Grocery("G002", "Tonno", "Rio Mare", 3.40, new GregorianCalendar(2024, Calendar.MAY, 7), 270);
        supermarket.addProduct(grocery2);

        Electronic electronic2 = new Electronic("E002", "Cuffie WH-1000XM4", "Sony", 290, 2, 50, 30);
        supermarket.addProduct(electronic2);

        Grocery grocery3 = new Grocery("G003", "Biscotti Grancereale", "Mulino Bianco", 1.50, new GregorianCalendar(2023, Calendar.SEPTEMBER, 23), 200);
        supermarket.addProduct(grocery3);

        Assert.assertEquals(grocery3, supermarket.getMinPrice());
    }

    @Test
    public void getMaxPriceTest() {
        Supermarket supermarket = new Supermarket();

        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        supermarket.addProduct(grocery1);

        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        supermarket.addProduct(electronic1);

        Grocery grocery2 = new Grocery("G002", "Tonno", "Rio Mare", 3.40, new GregorianCalendar(2024, Calendar.MAY, 7), 270);
        supermarket.addProduct(grocery2);

        Electronic electronic2 = new Electronic("E002", "Cuffie WH-1000XM4", "Sony", 290, 2, 50, 30);
        supermarket.addProduct(electronic2);

        Grocery grocery3 = new Grocery("G003", "Biscotti Grancereale", "Mulino Bianco", 1.50, new GregorianCalendar(2023, Calendar.SEPTEMBER, 23), 200);
        supermarket.addProduct(grocery3);

        Assert.assertEquals(electronic1, supermarket.getMaxPrice());
    }

    @Test
    public void findTest() {
        Supermarket supermarket = new Supermarket();

        Grocery grocery1 = new Grocery("G001", "Piadine", "Conad", 1.80, new GregorianCalendar(2022, Calendar.NOVEMBER, 20), 300);
        supermarket.addProduct(grocery1);

        Electronic electronic1 = new Electronic("E001", "Playstation 5", "Sony", 800, 2, 100, 5);
        supermarket.addProduct(electronic1);

        Grocery grocery2 = new Grocery("G002", "Tonno", "Rio Mare", 3.40, new GregorianCalendar(2024, Calendar.MAY, 7), 270);
        supermarket.addProduct(grocery2);

        Electronic electronic2 = new Electronic("E002", "Cuffie WH-1000XM4", "Sony", 290, 2, 50, 30);
        supermarket.addProduct(electronic2);

        Grocery grocery3 = new Grocery("G003", "Biscotti Grancereale", "Mulino Bianco", 1.50, new GregorianCalendar(2023, Calendar.SEPTEMBER, 23), 200);
        supermarket.addProduct(grocery3);

        Assert.assertEquals(2, supermarket.find("Sony").size());
        Assert.assertEquals("Cuffie WH-1000XM4", supermarket.find("Sony").get(1).getDescription());
    }
}