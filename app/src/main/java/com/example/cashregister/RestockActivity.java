package com.example.cashregister;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RestockActivity extends AppCompatActivity implements View.OnClickListener {
    List<Product> products;
    ProductListBaseAdapter adapter;
    Product product;
    ListView productListView;

    EditText add_to_quantity;
    Button okButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        // Set adapter for the listview
        products = ((MyApp) getApplication()).productManager.getProducts();
        adapter = new ProductListBaseAdapter(this, products);

        productListView = findViewById(R.id.productListView);
        productListView.setAdapter(adapter);

        // when a product is selected
        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                product = (Product) productListView.getItemAtPosition(position);
            }
        });

        // Ok & Cancel buttons
        add_to_quantity = findViewById(R.id.add_to_quantity);
        okButton = findViewById(R.id.ok_button);
        cancelButton = findViewById(R.id.cancel_button);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String quantityToAdd = add_to_quantity.getText().toString();

        switch (id) {
            case R.id.ok_button:
                if (product == null || quantityToAdd.isEmpty()) {
                    Toast.makeText(RestockActivity.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
                } else {
                    product.quantity += Integer.parseInt(quantityToAdd);
                    add_to_quantity.setText("");
                    adapter.notifyDataSetChanged();
                }
                break;
            case R.id.cancel_button:
                // Go back to previous page
                finish();
                break;
        }
    }
}
