package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView productTypeView, quantityView, totalView;
    ListView listView;
    Button buyButton, managerButton;
    NumberPicker numberPicker;

    ProductManager productManager = ((MyApp) getApplication()).productManager;
    List<Product> products = productManager.getProducts();

    Double total, price = 0.0;
    int qtyInStock, selectedItemPosition;

    // Adapter
    ProductListBaseAdapter adapter = new ProductListBaseAdapter(this, products);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productTypeView = findViewById(R.id.product_type);
        quantityView = findViewById(R.id.quantity);
        totalView = findViewById(R.id.total);

        numberPicker = findViewById(R.id.number_picker);

        // NumberPicker
        if (numberPicker != null) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(100);
            // wrap the wheel
            numberPicker.setWrapSelectorWheel(true);

            numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    int quantity = numberPicker.getValue();
                    quantityView.setText(String.valueOf(quantity));

                    if (price != 0.0) {
                        total = quantity * price;
                        totalView.setText(String.format("%.2f", total));

                        if (quantity > qtyInStock) {
                            Toast.makeText(MainActivity.this, "Not enough quantity in the stock!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }

        // Set ListView adapter
        listView = findViewById(R.id.productListView);
        listView.setAdapter(adapter);

        // Product ListView is clicked
        // Calculate total price
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Product p = (Product) listView.getItemAtPosition(position);
                productTypeView.setText(p.name);
                price = p.price;
                qtyInStock = p.quantity;
                selectedItemPosition = position;
            }
        });


        // Buy button clicked
        buyButton = findViewById(R.id.buy);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantityView.getText().toString().equals("Quantity") || quantityView.getText().toString().equals("0") || productTypeView.getText().toString().equals("Product Type")) {
                    Toast.makeText(MainActivity.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
                }

                Product p = (Product) listView.getItemAtPosition(selectedItemPosition);
                p.quantity -= Integer.parseInt(quantityView.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
