package it.unisa.medicaltests;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MedicalTestListTest {

    @Test
    public void addMedicalTest() {
        MedicalTestList medicalTestList = new MedicalTestList();

        Radiography mt1 = new Radiography("Adam Smith", true, "Ginocchio destro");
        medicalTestList.addMedicalTest(mt1);

        Echocardiogram mt2 = new Echocardiogram("Robert Black", Echocardiogram.Variants.WITH_CONTRAST, 50);
        medicalTestList.addMedicalTest(mt2);

        Assert.assertEquals(2, medicalTestList.getMedicalTestList().size());
    }

    @Test
    public void getMedicalTestByDate() {
        MedicalTestList medicalTestList = new MedicalTestList();

        Radiography mt1 = new Radiography("Adam Smith", true, "Ginocchio destro");
        medicalTestList.addMedicalTest(mt1);
        mt1.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 27));

        Echocardiogram mt2 = new Echocardiogram("Robert Black", Echocardiogram.Variants.WITH_CONTRAST, 50);
        medicalTestList.addMedicalTest(mt2);
        mt2.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 26));

        Echocardiogram mt3 = new Echocardiogram("Robert Black", Echocardiogram.Variants.SIMPLE, 65);
        medicalTestList.addMedicalTest(mt3);

        Radiography mt4 = new Radiography("Adam Smith", false, "Anca");
        medicalTestList.addMedicalTest(mt4);
        mt4.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 27));

        Echocardiogram mt5 = new Echocardiogram("Robert Black", Echocardiogram.Variants.SIMPLE, 70);
        medicalTestList.addMedicalTest(mt5);

        Assert.assertEquals(2, medicalTestList.getMedicalTestByDate(new GregorianCalendar(2022, Calendar.OCTOBER, 27)).size());
    }

    @Test
    public void getMedicalTestByDoctor() {
        MedicalTestList medicalTestList = new MedicalTestList();

        Radiography mt1 = new Radiography("Adam Smith", true, "Ginocchio destro");
        medicalTestList.addMedicalTest(mt1);
        mt1.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 27));

        Echocardiogram mt2 = new Echocardiogram("Robert Black", Echocardiogram.Variants.WITH_CONTRAST, 50);
        medicalTestList.addMedicalTest(mt2);
        mt2.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 26));

        Echocardiogram mt3 = new Echocardiogram("Robert Black", Echocardiogram.Variants.SIMPLE, 65);
        medicalTestList.addMedicalTest(mt3);

        Radiography mt4 = new Radiography("Adam Smith", false, "Anca");
        medicalTestList.addMedicalTest(mt4);
        mt4.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 27));

        Echocardiogram mt5 = new Echocardiogram("Robert Black", Echocardiogram.Variants.SIMPLE, 70);
        medicalTestList.addMedicalTest(mt5);

        Assert.assertEquals(3, medicalTestList.getMedicalTestByDoctor("Robert Black").size());
    }

    @Test
    public void getAverageCost() {
        MedicalTestList medicalTestList = new MedicalTestList();

        Radiography mt1 = new Radiography("Adam Smith", true, "Ginocchio destro");
        medicalTestList.addMedicalTest(mt1);
        mt1.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 27));

        Echocardiogram mt2 = new Echocardiogram("Robert Black", Echocardiogram.Variants.WITH_CONTRAST, 50);
        medicalTestList.addMedicalTest(mt2);
        mt2.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 26));

        Echocardiogram mt3 = new Echocardiogram("Robert Black", Echocardiogram.Variants.SIMPLE, 65);
        medicalTestList.addMedicalTest(mt3);

        Radiography mt4 = new Radiography("Adam Smith", false, "Anca");
        medicalTestList.addMedicalTest(mt4);
        mt4.conductTest("Nessun problema", new GregorianCalendar(2022, Calendar.OCTOBER, 27));

        Echocardiogram mt5 = new Echocardiogram("Robert Black", Echocardiogram.Variants.SIMPLE, 70);
        medicalTestList.addMedicalTest(mt5);

        Assert.assertEquals(25.20, medicalTestList.getAverageCost(), 0);
    }
}