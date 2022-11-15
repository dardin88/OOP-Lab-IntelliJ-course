package it.unisa.carseller;

import java.io.Serializable;

public class Car implements Serializable {
    final private String brand;
    final private String model;
    final private int manufacturingYear;
    private double price;

    public Car(String brand, String model, int manufacturingYear, double price) {
        this.brand = brand;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
