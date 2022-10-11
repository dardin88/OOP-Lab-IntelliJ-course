import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
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

    public void readUserDataFromFile(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            int code = Integer.parseInt(input.nextLine());
            String name = input.nextLine();
            String lastName = input.nextLine();
            User user = new User(code, name, lastName);
            user.setUsedMinutes(Integer.parseInt(input.nextLine()));
            user.setUsedSMS(Integer.parseInt(input.nextLine()));
            user.setUsedMB(Double.parseDouble(input.nextLine()));
            this.users.add(user);
        }
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
