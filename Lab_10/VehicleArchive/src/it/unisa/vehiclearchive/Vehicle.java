package it.unisa.vehiclearchive;

public class Vehicle {

    private final String brand;
    private final String model;
    private String licensePlate;
    private final int year;

    public Vehicle(String brand, String model, String licensePlate, int year) {
        this.brand = brand;
        this.model = model;
        this.licensePlate = licensePlate;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return this.getBrand() + " " + this.getModel() + " " + this.getLicensePlate() + " " + this.getYear();
    }
}
