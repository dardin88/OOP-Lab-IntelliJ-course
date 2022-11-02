package it.unisa.supermarket;

import java.util.GregorianCalendar;

public abstract class Product {

    final private String code;
    final private String description;
    final private String brand;
    private double price;
    private boolean onSale;
    private double originalPrice;
    private GregorianCalendar lastOnSaleDay;

    public Product(String code, String description, String brand, double price) {
        this.code = code;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.originalPrice = price;
        this.onSale = false;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.originalPrice = price;
    }

    public void putOnSale(double p, GregorianCalendar g) {
        this.onSale = true;
        this.price -= this.price * p / 100;
        this.lastOnSaleDay = g;
    }

    public void checkOnSale() {
        if (this.onSale && this.lastOnSaleDay.before(new GregorianCalendar())) {
            this.onSale = false;
            this.price = this.originalPrice;
        }
    }

    public abstract boolean buy(int p);

}
