package com.example.cashregister;

import java.util.List;

public class HistoryManager {
    List<History> historyList;

    public void add(History history){
        historyList.add(history);
    }

    public List<History> getHistoryList(){
        return historyList;
    }
}
