public class BankAccount {

    private final int accountNumber;
    private static int totalNumberOfAccounts = 0;
    private double balance;

    /**
     * A bank account has a balance that can be changed by deposits and withdrawals.
     */
    public BankAccount() {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = 0;
    }

    public BankAccount(double initialBalance) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = initialBalance;
    }

    /**
     * Deposit money to the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance = balance + amount;
    }

    /**
     * Withdraws money from the bank account.
     *
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
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

}