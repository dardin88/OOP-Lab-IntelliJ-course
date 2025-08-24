package it.unisa.supermarket;

import java.util.Comparator;

public class ProductComparatorByCode implements Comparator<Product> {

    @Override
    public int compare(Product product1, Product product2) {
        return product1.getCode().compareTo(product2.getCode());
    }
}
