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
    private List<Product> products;
    private ProductListAdapter productListAdapter;
    private Product selectedProduct;
    private ListView productListView;

    private EditText addToQuantity;
    private Button okButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        // Set adapter for the listview
        products = ((MyApp) getApplication()).getProductManager().getProducts();
        productListAdapter = new ProductListAdapter(this, products);

        productListView = findViewById(R.id.productListView);
        productListView.setAdapter(productListAdapter);

        // when a product is selected
        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedProduct = (Product) productListView.getItemAtPosition(position);
            }
        });

        // Ok & Cancel buttons
        addToQuantity = findViewById(R.id.add_to_quantity);
        okButton = findViewById(R.id.ok_button);
        cancelButton = findViewById(R.id.cancel_button);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String quantityToAdd = addToQuantity.getText().toString();

        switch (id) {
            case R.id.ok_button:
                if (selectedProduct == null || quantityToAdd.isEmpty()) {
                    Toast.makeText(RestockActivity.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
                } else {
                    selectedProduct.setQuantity(selectedProduct.getQuantity() + Integer.parseInt(quantityToAdd));
                    addToQuantity.setText("");
                    productListAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.cancel_button:
                // Go back to previous page
                finish();
                break;
        }
    }
}
