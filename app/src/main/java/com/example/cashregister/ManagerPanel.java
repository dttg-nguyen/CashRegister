package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerPanel extends AppCompatActivity implements View.OnClickListener {
    Button historyButton;
    Button restockButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);

        historyButton = findViewById(R.id.history_button);
        historyButton.setOnClickListener(this);

        restockButton = findViewById(R.id.restock_button);
        restockButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.history_button:
                Intent intent;
                intent = new Intent(ManagerPanel.this, HistoryAdapterActivity.class);
                startActivity(intent);
                break;
            case R.id.restock_button:
                Toast.makeText(this, "Manager button clicks", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
