package it.unisa.supermarket;

public class Electronic extends Product {
    final private int basicWarranty;
    private float annualWarrantyPrice;
    private int quantity;

    public Electronic(String code, String description, String brand, double price, int basicWarranty, float annualWarrantyPrice, int quantity) {
        super(code, description, brand, price);
        this.basicWarranty = basicWarranty;
        this.annualWarrantyPrice = annualWarrantyPrice;
        this.quantity = quantity;
    }

    public int getBasicWarranty() {
        return basicWarranty;
    }

    public float getAnnualWarrantyPrice() {
        return annualWarrantyPrice;
    }

    public void setAnnualWarrantyPrice(float annualWarrantyPrice) {
        this.annualWarrantyPrice = annualWarrantyPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float computeWarrantyPrice(int a) {
        return annualWarrantyPrice * a;
    }

    @Override
    public boolean buy(int q) {
        if (q <= this.getQuantity()) {
            this.setQuantity(this.getQuantity() - q);
            return true;
        }
        return false;
    }
}
