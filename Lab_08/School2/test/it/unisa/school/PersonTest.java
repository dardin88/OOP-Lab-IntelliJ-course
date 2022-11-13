package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void toStringTest() {
        Person p = new Person("Alice", "Rossi", 1997, "aliros", "testPassword");
        Assert.assertEquals("Nome='Alice', Cognome='Rossi', Anno di nascita=1997",
                p.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void tooOldYearTest() {
        new Person("Alice", "Rossi", 1897, "aliror", "testPassword");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shortUserIdTest() {
        new Person("Alice", "Rossi", 1997, "alir", "testPassword");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spaceInUserIdTest() {
        new Person("Alice", "Rossi", 1997, "ali ros", "testPassword");
    }

    @Test(expected = IllegalArgumentException.class)
    public void spaceInPasswordTest() {
        new Person("Alice", "Rossi", 1997, "aliros", "test Password");
    }
}