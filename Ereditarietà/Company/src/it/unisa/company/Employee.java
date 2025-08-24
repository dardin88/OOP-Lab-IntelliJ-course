package it.unisa.company;

public class Employee extends Staff {

    private String jobTitle;
    private float hourlyWage;

    public Employee(String name, String lastName, String jobTitle, float hourlyWage) {
        super(name, lastName);
        this.setJobTitle(jobTitle);
        this.setHourlyWage(hourlyWage);
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage) {
        this.hourlyWage = hourlyWage;
        this.updateSalary(hourlyWage);
    }

    private void updateSalary(float hourlyWage) {
        this.setWage(40 * hourlyWage);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Incarico='" + jobTitle + '\'';
    }
}
