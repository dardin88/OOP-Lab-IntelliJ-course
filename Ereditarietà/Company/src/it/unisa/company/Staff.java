package it.unisa.company;

public class Staff {

    final private String name;
    final private String lastName;
    private float wage;

    public Staff(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Nome='" + name + '\'' +
                ", Cognome='" + lastName + '\'' +
                ", Stipendio=" + wage;
    }
}
