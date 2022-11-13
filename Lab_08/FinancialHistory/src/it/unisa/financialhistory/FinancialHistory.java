package it.unisa.financialhistory;

import java.util.ArrayList;
import java.util.List;

public class FinancialHistory {
    final private Person person;
    private double balance;
    final private List<Movement> movements;

    public FinancialHistory(Person person, double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Non puoi creare un conto con saldo negativo");
        this.person = person;
        this.balance = balance;
        this.movements = new ArrayList<>();
    }

    public void receiveFrom(int amount, String source) {
        this.movements.add(new Movement(source, amount));
        this.balance += amount;
    }

    public void spendFor(int amount, String reason) {
        if (amount > balance)
            throw new IllegalArgumentException("Non hai abbastanza denaro");
        this.movements.add(new Movement(reason, amount));
        this.balance -= amount;
    }

    public double cashOnHand() {
        return balance;
    }

    public double totalReceivedFrom(String source) {
        double totalReceived = 0;
        for (Movement m : movements) {
            if (m.getDescription().equals(source) && m.getAmount() > 0) {
                totalReceived += m.getAmount();
            }
        }
        return totalReceived;
    }

    public double totalSpentFor(String reason) {
        double totalSpent = 0;
        for (Movement m : movements) {
            if (m.getDescription().equals(reason) && m.getAmount() < 0) {
                totalSpent += m.getAmount();
            }
        }
        return totalSpent;
    }

    public void printMovements() {
        for (Movement m : movements) {
            System.out.println(m.getDescription() + "," + m.getAmount() + ";");
        }
    }

}
