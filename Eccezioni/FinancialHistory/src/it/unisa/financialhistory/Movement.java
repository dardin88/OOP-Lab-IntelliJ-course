package it.unisa.financialhistory;

public class Movement {
    final private String description;
    final private double amount;

    public Movement(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}
