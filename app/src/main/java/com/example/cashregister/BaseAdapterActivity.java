//package com.example.cashregister;
//
//import android.os.Bundle;
//import android.widget.ListView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BaseAdapterActivity extends AppCompatActivity {
//    ListView baseAdapterList;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // generate list data
//        // find listview, create adapter for the view with the list data
//        // bind adapter with view
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Pants", 10,20.44));
//        products.add(new Product("Shoes", 100,10.44));
//        products.add(new Product("Hats", 30,5.9));
//
//        baseAdapterList = findViewById(R.id.baseAdapter_productList);
//        ProductListBaseAdapter adapter = new ProductListBaseAdapter(this, products);
//        baseAdapterList.setAdapter(adapter);
//    }
//}
