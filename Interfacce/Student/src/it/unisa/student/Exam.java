package it.unisa.student;

import java.util.GregorianCalendar;

public class Exam {
    private final String topic;
    private final GregorianCalendar date;
    private final int grade;

    public Exam(String topic, GregorianCalendar date, int grade) {
        this.topic = topic;
        this.date = date;
        this.grade = grade;
    }

    public String getTopic() {
        return topic;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getGrade() {
        return grade;
    }
}
