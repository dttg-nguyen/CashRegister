package com.example.cashregister;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    List<History> historyList;

    public HistoryManager(){
        historyList = new ArrayList<>();
    }

    public void add(History history){
        historyList.add(history);
    }

    public List<History> getHistoryList(){
        return historyList;
    }
}
