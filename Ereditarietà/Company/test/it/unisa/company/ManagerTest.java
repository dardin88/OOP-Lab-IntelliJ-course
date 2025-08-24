package it.unisa.company;

import org.junit.Assert;
import org.junit.Test;

public class ManagerTest {

    @Test
    public void employerInitialWageTest() {
        Manager manager = new Manager("John", "Smith", "Area Director", 500, "Human Resources");
        Assert.assertEquals(0, manager.getWage(), 0);
    }

    @Test
    public void setWorkedHoursTest() {
        Manager manager = new Manager("John", "Smith", "Area Director", 500, "Human Resources");
        manager.setWorkedHours(20);
        Assert.assertEquals(10000, manager.getWage(), 0);
    }

    @Test
    public void setHourlyWageTest() {
        Manager manager = new Manager("John", "Smith", "Area Director", 500, "Human Resources");
        manager.setWorkedHours(20);
        manager.setHourlyWage(600);
        Assert.assertEquals(12000, manager.getWage(), 0);
    }
}