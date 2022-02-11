package com.example.cashregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ManagerPanel extends AppCompatActivity implements View.OnClickListener {
    Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);

        historyButton = findViewById(R.id.history_button);
        historyButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.history_button:
                Intent intent;
                intent = new Intent(ManagerPanel.this, HistoryAdapterActivity.class);
                startActivity(intent);
        }
    }
}
