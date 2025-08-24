package it.unisa.school;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void toStringTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        Assert.assertEquals("Nome='Roberto', Cognome='Bianchi', Anno di nascita=2005, Numero di assenze=3",
                s.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyStudentIdTest() {
        new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "", 3);
    }

    @Test
    public void addExamTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("Programmazione Object Oriented", 31);
        s.addExam("Ingegneria del Software", 25);
        Assert.assertEquals(2, s.getNumberOfPassedExams());
    }

    @Test
    public void getAverageGradeTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("Programmazione Object Oriented", 31);
        s.addExam("Ingegneria del Software", 25);
        Assert.assertEquals(27.5, s.getAverageGrade(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addInvalidGradeTest() {
        Student s = new Student("Roberto", "Bianchi", 2005, "robbia", "testPassword", "0522500103", 3);
        s.addExam("Programmazione Object Oriented", 15);
    }

}