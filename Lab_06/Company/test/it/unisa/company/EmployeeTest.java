package it.unisa.company;

import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

    @Test
    public void employerInitialWageTest() {
        Employee employee = new Employee("John", "Smith", "Consultant", 50);
        Assert.assertEquals(2000, employee.getWage(), 0);
    }

    @Test
    public void setHourlyWageTest() {
        Employee employee = new Employee("John", "Smith", "Consultant", 50);
        employee.setHourlyWage(60);
        Assert.assertEquals(2400, employee.getWage(), 0);
    }
}