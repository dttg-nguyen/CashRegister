package com.example.cashregister;

import android.app.Application;
import android.text.method.HideReturnsTransformationMethod;

public class MyApp extends Application {
    ProductManager productManager = new ProductManager();
    HistoryManager historyManager = new HistoryManager();
}
