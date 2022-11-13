package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void toStringTest() {
        Person p = new Person("Alice", "Rossi", 1997);
        Assert.assertEquals("Nome='Alice', Cognome='Rossi', Anno di nascita=1997",
                p.toString());
    }
}