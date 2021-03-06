package com.example.cashregister;

import java.util.Arrays;
import java.util.List;

public class ProductManager {
    private final List<Product> products;

    public ProductManager() {
        products = Arrays.asList(
                new Product("Pants", 10, 20.44),
                new Product("Shoes", 100, 10.44),
                new Product("Hats", 30, 5.9));
    }

    public List<Product> getProducts() {
        return products;
    }
}
