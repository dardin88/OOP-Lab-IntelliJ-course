package it.unisa.vehiclearchive;

public class MotorVehicle extends Vehicle {

    public enum SupplyType {
        PETROL, DIESEL, HYBRID, ELECTRIC, GNL
    }

    private final SupplyType supply;
    private final int numberOfDoors;
    private final int numberOfSeats;

    public MotorVehicle(String brand, String model, String licensePlate, int year, SupplyType supply, int numberOfDoors, int numberOfSeats) throws WrongLicensePlateException {
        super(brand, model, licensePlate, year);

        if (!licensePlate.matches("[A-Z]{2}[0-9]{3}[A-Z]{2}")) {
            throw new WrongLicensePlateException();
        }

        this.supply = supply;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
    }

    public SupplyType getSupply() {
        return supply;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.getSupply();
    }
}
