package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryDetailsActivity extends AppCompatActivity {
    private TextView productName;
    private TextView totalPrice;
    private TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        productName = findViewById(R.id.history_details_productName);
        totalPrice = findViewById(R.id.history_details_totalPrice);
        date = findViewById(R.id.history_details_date);

        // Retrieve history details from intent passed by History Activity
        Intent intent = getIntent();
        productName.setText("Product: " + intent.getStringExtra("name"));
        totalPrice.setText("Price: " + intent.getStringExtra("totalPrice"));
        date.setText("Purchase Date: " + intent.getStringExtra("date"));
    }
}