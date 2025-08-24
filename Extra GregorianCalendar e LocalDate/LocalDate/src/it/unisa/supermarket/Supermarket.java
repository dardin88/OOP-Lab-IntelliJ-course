package it.unisa.supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Supermarket {

    private final List<Product> products;

    public Supermarket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        this.products.add(p);
        this.products.sort(new ProductComparatorByCode());
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getProductType(int i) {
        Product p = this.products.get(i);
        if (p instanceof Grocery) {
            return "Grocery";
        } else if (p instanceof Electronic) {
            return "Electronic";
        }
        return null;
    }

    public Product getMinPrice() {
        return Collections.min(this.products, new ProductComparatorByPrice());
    }

    public Product getMaxPrice() {
        return Collections.max(this.products, new ProductComparatorByPrice());
    }

    public List<Product> find(String brand) {
        List<Product> result = new ArrayList<>();
        for (Product p : this.products) {
            if (p.getBrand().equals(brand)) {
                result.add(p);
            }
        }
        return result;
    }
}
