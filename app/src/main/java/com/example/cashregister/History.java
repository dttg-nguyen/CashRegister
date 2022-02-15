package com.example.cashregister;

import java.util.Date;

public class History {
    private final String productName;
    private final String quantity;
    private final double totalPrice;
    private final Date purchaseDate;

    public History(String name, String qty, double total, Date date) {
        productName = name;
        quantity = qty;
        totalPrice = total;
        purchaseDate = date;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }
}
