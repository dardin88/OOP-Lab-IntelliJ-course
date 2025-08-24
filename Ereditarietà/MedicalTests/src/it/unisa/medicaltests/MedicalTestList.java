package it.unisa.medicaltests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

public class MedicalTestList {

    private final List<MedicalTest> medicalTestList;

    public MedicalTestList() {
        this.medicalTestList = new ArrayList<>();
    }

    public void addMedicalTest(MedicalTest mt) {
        this.medicalTestList.add(mt);
        Collections.sort(medicalTestList);
    }

    public List<MedicalTest> getMedicalTestByDate(GregorianCalendar date) {
        List<MedicalTest> result = new ArrayList<>();
        for (MedicalTest mt : medicalTestList) {
            if (mt.getDate() != null && mt.getDate().equals(date)) {
                result.add(mt);
            }
        }
        return result;
    }

    public List<MedicalTest> getMedicalTestByDoctor(String doctorName) {
        List<MedicalTest> result = new ArrayList<>();
        for (MedicalTest mt : medicalTestList) {
            if (mt.getDoctorName().equals(doctorName)) {
                result.add(mt);
            }
        }
        return result;
    }

    public double getAverageCost() {
        double averageCost = 0;
        for (MedicalTest mt : medicalTestList) {
            averageCost += mt.getCost();
        }
        averageCost /= medicalTestList.size();
        return Math.round(averageCost * 100.0) / 100.0;
    }

    public List<MedicalTest> getMedicalTestList() {
        return medicalTestList;
    }
}
