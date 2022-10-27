package it.unisa.medicaltests;

import java.util.GregorianCalendar;

public class MedicalTest implements Comparable<MedicalTest> {

    final private String doctorName;
    private double cost;
    private String report;

    private GregorianCalendar date;

    public MedicalTest(String doctorName) {
        this.doctorName = doctorName;

    }

    public void conductTest(String report, GregorianCalendar date) {
        this.report = report;
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public double getCost() {
        return cost;
    }

    public String getReport() {
        return report;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "MedicalTest{" +
                "doctorName='" + doctorName + '\'' +
                ", cost=" + cost +
                ", report='" + report + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(MedicalTest medicalTest) {
        if (this.getDate() == null && medicalTest.getDate() == null) {
            return +1;
        }
        if (this.getDate() == null) {
            return +1;
        }
        if (medicalTest.getDate() == null) {
            return -1;
        }
        return this.getDate().compareTo(medicalTest.getDate());
    }
}