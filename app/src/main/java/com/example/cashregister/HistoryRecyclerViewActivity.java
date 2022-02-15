package com.example.cashregister;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryRecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_recyclerview);

        // get view
        recyclerView = findViewById(R.id.history_recyclerView);

        // get history list
        HistoryManager historyManager = ((MyApp) getApplication()).getHistoryManager();
        List<History> historyList = historyManager.getHistoryList();

        // adapter + view
        HistoryRecyclerViewAdapter adapter = new HistoryRecyclerViewAdapter(this, historyList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
