package it.unisa.country;

public class Country implements Comparable<Country> {

    final private String name;
    final private double surfaceArea;

    public Country(String name, double surfaceArea) {
        this.name = name;
        this.surfaceArea = surfaceArea;
    }

    public String getName() {
        return name;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    @Override
    public int compareTo(Country country) {
        return Double.compare(this.surfaceArea, country.surfaceArea);
    }

}