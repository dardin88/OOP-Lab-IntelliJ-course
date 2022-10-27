package it.unisa.school;

public class Student extends Person {

    private int numberOfAbsences;

    public Student(String name, String surname, int birthYear, int numberOfAbsences) {
        super(name, surname, birthYear);
        this.numberOfAbsences = numberOfAbsences;
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

    @Override
    public String toString() {
        return super.toString() +
                ", Numero di assenze=" + numberOfAbsences;
    }
}
