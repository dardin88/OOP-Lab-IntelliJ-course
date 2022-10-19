package it.unisa.country;

import org.junit.Assert;
import org.junit.Test;

public class DataSetTest {
    @Test
    public void testMinimum() {
        Country c1 = new Country("Italy", 301230);
        Country c2 = new Country("France", 543940);
        Country c3 = new Country("Netherlands", 41543);
        DataSet dataset = new DataSet();
        dataset.add(c1);
        dataset.add(c2);
        dataset.add(c3);
        Assert.assertEquals("Netherlands", dataset.getMinimum().getName());
    }

    @Test
    public void testMaximum() {
        Country c1 = new Country("Italy", 301230);
        Country c2 = new Country("France", 543940);
        Country c3 = new Country("Netherlands", 41543);
        DataSet dataset = new DataSet();
        dataset.add(c1);
        dataset.add(c2);
        dataset.add(c3);
        Assert.assertEquals("France", dataset.getMaximum().getName());
    }
}