package it.unisa.supermarket;

import java.time.LocalDate;

public class Grocery extends Product {

    private LocalDate expiringDate;
    private int weight;

    public Grocery(String code, String description, String brand, double price, LocalDate expiringDate, int weight) {
        super(code, description, brand, price);
        this.expiringDate = expiringDate;
        this.weight = weight;
    }

    public LocalDate getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(LocalDate expiringDate) {
        this.expiringDate = expiringDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.expiringDate);
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
