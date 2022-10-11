public class User {
    private final int code;
    private final String name;
    private final String lastName;
    private int usedMinutes;
    private int usedSMS;
    private double usedMB;
    private double totalCost;

    public User(int code, String name, String lastName) {
        this.code = code;
        this.name = name;
        this.lastName = lastName;
    }

    public void setUsedMinutes(int usedMinutes) {
        this.usedMinutes = usedMinutes;
    }

    public void setUsedSMS(int usedSMS) {
        this.usedSMS = usedSMS;
    }

    public void setUsedMB(double usedMB) {
        this.usedMB = usedMB;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUsedMinutes() {
        return usedMinutes;
    }

    public int getUsedSMS() {
        return usedSMS;
    }

    public double getUsedMB() {
        return usedMB;
    }

    public double getTotalCost() {
        return totalCost;
    }
}