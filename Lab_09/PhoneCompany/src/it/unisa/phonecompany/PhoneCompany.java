package it.unisa.phonecompany;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PhoneCompany {
    List<User> users;

    private final double minutePrice;
    private final double smsPrice;
    private final double gbPrice;

    public PhoneCompany(double minutePrice, double smsPrice, double gbPrice) {
        this.users = new ArrayList<>();
        this.minutePrice = minutePrice;
        this.smsPrice = smsPrice;
        this.gbPrice = gbPrice;
    }

    public List<User> getUsers() {
        return users;
    }

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        this.users = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            try {
                int code = Integer.parseInt(input.nextLine());
                String name = input.nextLine();
                String lastName = input.nextLine();
                User user = new User(code, name, lastName);
                user.setUsedMinutes(Integer.parseInt(input.nextLine()));
                user.setUsedSMS(Integer.parseInt(input.nextLine()));
                user.setUsedMB(Double.parseDouble(input.nextLine()));
                this.users.add(user);
            } catch (NoSuchElementException | NumberFormatException ex) {
                System.err.println("Il formato del file è errato!");
                ex.printStackTrace();
            }
        }
        input.close();
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
        for (User user : this.users) {
            output.println(user.getCode());
            output.println(user.getName());
            output.println(user.getLastName());
            output.println(user.getUsedMinutes());
            output.println(user.getUsedSMS());
            output.println(user.getUsedMB());
        }
        output.close();
    }

    @SuppressWarnings("unchecked")
    public void readSerializedDataFromFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        this.users = (List<User>) in.readObject();
        in.close();
    }

    public void writeSerializedDataToFile(File file) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(this.users);
        output.close();
    }

    public User findUserByCode(int code) {
        for (User user : this.users) {
            if (user.getCode() == code) {
                return user;
            }
        }
        return null;
    }

    public void computeUserCost(User user) {
        int usedMinutes = user.getUsedMinutes();
        int usedSMS = user.getUsedSMS();
        double usedMB = user.getUsedMB();
        user.setTotalCost(usedMinutes * minutePrice + usedSMS * smsPrice + usedMB * gbPrice / 1000);
    }
}
