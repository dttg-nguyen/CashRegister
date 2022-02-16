package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryDetailsActivity extends AppCompatActivity {
    private TextView productName;
    private TextView totalPrice;
    private TextView purchaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        productName = findViewById(R.id.history_details_productName);
        totalPrice = findViewById(R.id.history_details_totalPrice);
        purchaseDate = findViewById(R.id.history_details_purchase_date);

        // Retrieve history details from intent passed by History Activity
        Intent intent = getIntent();

        String productNameString = "Product: " + intent.getStringExtra("name");
        String totalPriceString = "Price: " + intent.getStringExtra("totalPrice");
        String purchaseDateString = "Purchase Date: " + intent.getStringExtra("purchaseDate");

        productName.setText(productNameString);
        totalPrice.setText(totalPriceString);
        purchaseDate.setText(purchaseDateString);
    }
}