package it.unisa.medicaltests;

public class Radiography extends MedicalTest {
    private String imgFileName;
    private final String organName;
    private final boolean medicalRequest;

    public Radiography(String doctorName, boolean medicalRequest, String organName) {
        super(doctorName);
        this.medicalRequest = medicalRequest;
        this.organName = organName;
        if (medicalRequest) {
            this.setCost(13);
        } else {
            this.setCost(20);
        }
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public String getOrganName() {
        return organName;
    }

    public boolean isMedicalRequest() {
        return medicalRequest;
    }

    @Override
    public String toString() {
        return "Radiography{" +
                "doctorName='" + this.getDoctorName() + '\'' +
                ", cost=" + this.getCost() +
                ", report='" + this.getReport() + '\'' +
                ", date=" + this.getDate() +
                ", imgFileName='" + imgFileName + '\'' +
                ", organName='" + organName + '\'' +
                ", medicalRequest=" + medicalRequest +
                '}';
    }
}
