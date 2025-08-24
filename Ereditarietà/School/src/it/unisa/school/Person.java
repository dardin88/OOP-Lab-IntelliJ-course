package it.unisa.school;

public class Person {

    final private String name;
    final private String surname;
    final private int birthYear;

    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Nome='" + name + '\'' +
                ", Cognome='" + surname + '\'' +
                ", Anno di nascita=" + birthYear;
    }
}
