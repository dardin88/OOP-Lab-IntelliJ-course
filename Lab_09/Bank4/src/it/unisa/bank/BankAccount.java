package it.unisa.bank;

import java.io.Serializable;

public class BankAccount implements Serializable {

    private final int accountNumber;
    static int totalNumberOfAccounts = 0;
    private final String customerName;
    private double balance;

    /**
     * A bank account has a balance that can be changed by deposits and withdrawals.
     */
    public BankAccount(String customerName) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = 0;
        this.customerName = customerName;
    }

    public BankAccount(String customerName, double initialBalance) throws IllegalArgumentException {
        if (initialBalance < 0) {
            throw new IllegalArgumentException();
        }
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = initialBalance;
        this.customerName = customerName;
    }

    public BankAccount(int accountNumber, String customerName, double initialBalance) throws IllegalArgumentException {
        if (initialBalance < 0) {
            throw new IllegalArgumentException();
        }
        totalNumberOfAccounts++;
        this.accountNumber = accountNumber;
        balance = initialBalance;
        this.customerName = customerName;
    }

    /**
     * Deposit money to the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException();
        }

        balance = balance - amount;
    }

    /**
     * Gets the number of the bank account.
     *
     * @return the account number
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the current balance of the bank account.
     *
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the name of the customer of the bank account.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }
}