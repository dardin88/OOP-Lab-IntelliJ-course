package it.unisa.vehiclearchive;

public class WrongLicensePlateException extends Exception {

    public WrongLicensePlateException() {
        super("La targa ha un formato errato!");
    }
}
