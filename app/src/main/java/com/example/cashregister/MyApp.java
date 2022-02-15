package com.example.cashregister;

import android.app.Application;
import android.text.method.HideReturnsTransformationMethod;

public class MyApp extends Application {
    private final ProductManager productManager = new ProductManager();
    private final HistoryManager historyManager = new HistoryManager();

    public ProductManager getProductManager() {
        return productManager;
    }

    public HistoryManager getHistoryManager() {
        return historyManager;
    }
}
