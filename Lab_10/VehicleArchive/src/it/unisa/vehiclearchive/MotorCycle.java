package it.unisa.vehiclearchive;

public class MotorCycle extends Vehicle {

    final private int numberOfWheels;
    final private int numberoOfPassengers;

    public MotorCycle(String brand, String model, String licensePlate, int year, int numberOfWheels, int numberoOfPassengers) throws WrongLicensePlateException {
        super(brand, model, licensePlate, year);

        if (!licensePlate.matches("[A-Z]{2}[0-9]{5}")) {
            throw new WrongLicensePlateException();
        }

        this.numberOfWheels = numberOfWheels;
        this.numberoOfPassengers = numberoOfPassengers;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public int getNumberoOfPassengers() {
        return numberoOfPassengers;
    }
}
