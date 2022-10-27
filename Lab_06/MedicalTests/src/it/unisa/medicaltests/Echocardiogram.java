package it.unisa.medicaltests;

public class Echocardiogram extends MedicalTest {

    public enum Variants {
        SIMPLE,
        WITH_CONTRAST,
        STRESS
    }

    private final Variants type;
    private final int patientAge;

    public Echocardiogram(String doctorName, Variants type, int patientAge) {
        super(doctorName);
        this.type = type;
        this.patientAge = patientAge;

        float cost;
        if (type == Variants.WITH_CONTRAST) {
            cost = 45;
        } else {
            cost = 30;
        }
        if (patientAge >= 65) {
            cost -= cost * 20 / 100;
        }
        this.setCost(cost);
    }

    public Variants getType() {
        return type;
    }

    public int getPatientAge() {
        return patientAge;
    }

    @Override
    public String toString() {
        return "Echocardiogram{" +
                "doctorName='" + this.getDoctorName() + '\'' +
                ", cost=" + this.getCost() +
                ", report='" + this.getReport() + '\'' +
                ", date=" + this.getDate() +
                ", type=" + type +
                ", patientAge=" + patientAge +
                '}';
    }
}
