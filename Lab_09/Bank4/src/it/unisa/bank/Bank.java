package it.unisa.bank;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount bankAccount) {
        this.accounts.add(bankAccount);
    }

    public BankAccount find(int accountNumber) {
        for (BankAccount ba : this.accounts) {
            if (ba.getAccountNumber() == accountNumber)
                return ba;
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
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

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.accounts = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            try {
                String accountLine = input.nextLine();
                String[] accountValues = accountLine.split(",");
                int accountNumber = Integer.parseInt(accountValues[0]);
                String customerName = accountValues[1];
                double balance = Double.parseDouble(accountValues[2]);
                if (accountValues.length == 3) {
                    BankAccount bankAccount = new BankAccount(accountNumber, customerName, balance);
                    this.accounts.add(bankAccount);
                } else {
                    double interestRate = Double.parseDouble(accountValues[3]);
                    SavingAccount savingAccount = new SavingAccount(accountNumber, customerName, balance, interestRate);
                    this.accounts.add(savingAccount);
                }
            } catch (NoSuchElementException | NumberFormatException ex) {
                System.err.println("Il formato del file è errato!");
                ex.printStackTrace();
            }
        }
    }

    public void writeUserDataToFile(File file, boolean overwrite) throws FileNotFoundException, FileAlreadyExistsException {
        if (!overwrite) {
            if (file.exists()) {
                throw new FileAlreadyExistsException("Il file già esiste!");
            } else {
                writeUserDataToFile(file);
            }
        } else {
            String tmpFileName = file.getParentFile().getName() + File.separator + "tmp_" + file.getName();
            File tmpFile = new File(tmpFileName);
            writeUserDataToFile(tmpFile);
            file.delete();
            tmpFile.renameTo(file);
        }
    }

    private void writeUserDataToFile(File file) throws FileNotFoundException {
        PrintWriter output = new PrintWriter(file);
        for (BankAccount bankAccount : this.accounts) {
            output.print(bankAccount.getAccountNumber());
            output.print("," + bankAccount.getCustomerName());
            output.print("," + bankAccount.getBalance());
            if (bankAccount instanceof SavingAccount) {
                output.print("," + ((SavingAccount) bankAccount).getInterestRate());
            }
            output.print("\n");
        }
        output.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.accounts = (List<BankAccount>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(this.accounts);
        output.close();
    }
}