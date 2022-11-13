package it.unisa.school;

import java.util.AbstractMap;
import java.util.HashMap;

public class Student extends Person {

    final private String studentId;
    private int numberOfAbsences;
    private final AbstractMap<String, Integer> passedExams;

    public Student(String name, String surname, int birthYear, String userId, String password, String studentId, int numberOfAbsences) {
        super(name, surname, birthYear, userId, password);
        if (studentId == null || studentId.isEmpty())
            throw new IllegalArgumentException("Matricola dello studente con formato errato");
        this.studentId = studentId;
        this.numberOfAbsences = numberOfAbsences;
        this.passedExams = new HashMap<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public void addAbsence() {
        this.numberOfAbsences++;
    }

    public void removeAbsence() {
        this.numberOfAbsences--;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void addExam(String examName, int grade) {
        if (grade < 18 || grade > 31)
            throw new IllegalArgumentException("Voto non valido (minore di 18 o maggiore di 30 e lode)");
        this.passedExams.put(examName, grade);
    }

    public int getNumberOfPassedExams() {
        return this.passedExams.size();
    }

    public AbstractMap<String, Integer> getPassedExams() {
        return passedExams;
    }

    public double getAverageGrade() {
        double averageGrade = 0;
        for (int grade : this.passedExams.values()) {
            if (grade == 31)
                grade--;
            averageGrade += grade;
        }
        return averageGrade / this.getNumberOfPassedExams();
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
