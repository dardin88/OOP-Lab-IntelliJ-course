package it.unisa.supermarket;

import java.util.GregorianCalendar;

public class Grocery extends Product {

    private GregorianCalendar expiringDate;
    private int weight;

    public Grocery(String code, String description, String brand, double price, GregorianCalendar expiringDate, int weight) {
        super(code, description, brand, price);
        this.expiringDate = expiringDate;
        this.weight = weight;
    }

    public GregorianCalendar getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(GregorianCalendar expiringDate) {
        this.expiringDate = expiringDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isExpired() {
        return new GregorianCalendar().after(this.expiringDate);
    }

    @Override
    public boolean buy(int p) {
        if (p <= this.weight) {
            this.weight -= p;
            return true;
        }
        return false;
    }
}
