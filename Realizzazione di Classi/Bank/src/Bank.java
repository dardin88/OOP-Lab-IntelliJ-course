import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(double initialBalance, String customerName) {
        BankAccount newAccount = new BankAccount(initialBalance, customerName);
        this.accounts.add(newAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.deposit(amount);
    }

    public void withdraw(int accountNumber, double amount) {
        BankAccount account = this.find(accountNumber);
        account.withdraw(amount);
    }

    public double getBalance(int accountNumber) {
        BankAccount account = this.find(accountNumber);
        return account.getBalance();
    }

    public void transfer(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = this.find(fromAccountNumber);
        BankAccount toAccount = this.find(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}