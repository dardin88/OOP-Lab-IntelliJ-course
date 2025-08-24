public class BankAccount {

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

    public BankAccount(double initialBalance, String customerName) {
        totalNumberOfAccounts++;
        accountNumber = totalNumberOfAccounts;
        balance = initialBalance;
        this.customerName = customerName;
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

    /**
     * Gets the name of the customer of the bank account.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }
}