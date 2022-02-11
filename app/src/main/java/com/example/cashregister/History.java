package com.example.cashregister;

import java.util.Date;

public class History {
    String productName;
    String quantity;
    Double totalPrice;
    Date purchaseDate;

    public History(String name, String qty, Double total, Date date) {
        productName = name;
        quantity = qty;
        totalPrice = total;
        purchaseDate = date;
    }
}
