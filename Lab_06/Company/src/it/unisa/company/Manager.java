package it.unisa.company;

public class Manager extends Employee {

    private String expertiseArea;
    private int workedHours;

    public Manager(String name, String lastName, String jobTitle, float hourlyWage, String expertiseArea) {
        super(name, lastName, jobTitle, hourlyWage);
        this.updateSalary(workedHours, hourlyWage);
        this.setExpertiseArea(expertiseArea);
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
        this.updateSalary(workedHours, this.getHourlyWage());
    }

    @Override
    public void setHourlyWage(float hourlyWage) {
        super.setHourlyWage(hourlyWage);
        this.updateSalary(this.workedHours, hourlyWage);
    }

    private void updateSalary(int workedHours, float hourlyWage) {
        if (workedHours <= 40) {
            float wage = workedHours * hourlyWage;
            this.setWage(wage);
        } else {
            int extraHours = workedHours - 40;
            float wage = 40 * hourlyWage;
            wage += extraHours * hourlyWage * 1.5;
            this.setWage(wage);
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Area di competenza='" + expertiseArea + '\'';
    }
}
