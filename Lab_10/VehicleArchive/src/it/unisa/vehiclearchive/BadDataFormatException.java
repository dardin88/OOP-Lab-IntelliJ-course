package it.unisa.vehiclearchive;

public class BadDataFormatException extends RuntimeException {

    public BadDataFormatException() {
        super("I dati sono in un formato errato!");
    }
}
