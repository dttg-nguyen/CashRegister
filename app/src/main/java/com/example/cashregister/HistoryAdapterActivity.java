package com.example.cashregister;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapterActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_recyclerview);

        // get view
        recyclerView = findViewById(R.id.history_recyclerView);

        // get history list
        HistoryManager historyManager = ((MyApp) getApplication()).historyManager;
        List<History> historyList = historyManager.getHistoryList();

        // adapter + view
        HistoryRecyclerViewAdapter adapter = new HistoryRecyclerViewAdapter(this, historyList);
        recyclerView.setAdapter(adapter);
    }
}
