package it.unisa.student;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StudentTest {
    @Test
    public void newStudentTest() {
        Student student = new Student("Dario", "Di Nucci");
        Assert.assertEquals("Dario", student.getFirstName());
        Assert.assertEquals("Di Nucci", student.getLastName());
        Assert.assertTrue(student.getExams().isEmpty());
    }

    @Test
    public void oneExamTest() {
        Student student = new Student("Dario", "Di Nucci");

        Exam exam = new Exam("Object Oriented Programming", new GregorianCalendar(2023, Calendar.JANUARY, 10), 30);
        student.registerExam(exam);

        Assert.assertEquals(1, student.getExams().size(), 0);
        Assert.assertEquals(30, student.computeAverageGrade(), 0);
    }

    @Test
    public void twoExamTest() {
        Student student = new Student("Dario", "Di Nucci");

        Exam exam1 = new Exam("Object Oriented Programming", new GregorianCalendar(2023, Calendar.JANUARY, 10), 30);
        student.registerExam(exam1);

        Exam exam2 = new Exam("Software Engineering", new GregorianCalendar(2024, Calendar.JANUARY, 20), 28);
        student.registerExam(exam2);

        Assert.assertEquals(2, student.getExams().size(), 0);
        Assert.assertEquals(29, student.computeAverageGrade(), 0);
    }

    @Test
    public void studentsOrderTest() {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("Adam", "Sandler");
        studentList.add(student1);

        Student student2 = new Student("Owen", "Wilson");
        studentList.add(student2);

        Student student3 = new Student("Robert", "De Niro");
        studentList.add(student3);

        Student student4 = new Student("Ben", "Stiller");
        studentList.add(student4);

        Student student5 = new Student("Dustin", "Hoffman");
        studentList.add(student5);

        Collections.sort(studentList);

        Assert.assertEquals("De Niro", studentList.get(0).getLastName());
        Assert.assertEquals("Wilson", studentList.get(4).getLastName());
    }
}