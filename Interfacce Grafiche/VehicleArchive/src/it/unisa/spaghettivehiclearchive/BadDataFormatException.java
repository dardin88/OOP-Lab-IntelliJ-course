package it.unisa.spaghettivehiclearchive;

public class BadDataFormatException extends RuntimeException {

    public BadDataFormatException() {
        super("I dati sono in un formato errato!");
    }
}
