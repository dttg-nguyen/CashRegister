package com.example.cashregister;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView productTypeView, quantityView, totalView;
    private ListView listView;
    private Button buyButton, managerButton;
    private NumberPicker numberPicker;

    int selectedQuantity = -1;
    private double total = 0.0;

    private ProductListAdapter productListAdapter;
    private Product selectedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productTypeView = findViewById(R.id.product_type);
        quantityView = findViewById(R.id.quantity);
        totalView = findViewById(R.id.total);

        numberPicker = findViewById(R.id.number_picker);

        // NumberPicker
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(100);
        // wrap the wheel
        numberPicker.setWrapSelectorWheel(true);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                selectedQuantity = numberPicker.getValue();
                quantityView.setText(String.valueOf(selectedQuantity));

                if (selectedProduct != null) {
                    totalCalculationAndQuantityInStockValidate();
                }
            }
        });

        // ListView
        // Get product list
        ProductManager productManager = ((MyApp) getApplication()).getProductManager();
        List<Product> products = productManager.getProducts();

        // Adapter
        productListAdapter = new ProductListAdapter(this, products);

        // Set ListView adapter
        listView = findViewById(R.id.productListView);
        listView.setAdapter(productListAdapter);

        // Product ListView is clicked
        // Calculate total price
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                selectedProduct = (Product) listView.getItemAtPosition(position);

                productTypeView.setText(selectedProduct.getName());
                if (selectedQuantity > -1) {
                    totalCalculationAndQuantityInStockValidate();
                }
            }
        });

        // Buy button onClick
        buyButton = findViewById(R.id.buy);
        buyButton.setOnClickListener(this);

        // Manager button onClick
        managerButton = findViewById(R.id.manager);
        managerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        String quantityViewString = quantityView.getText().toString();
        String productTypeViewString = productTypeView.getText().toString();

        switch (id) {
            case R.id.buy:
                if (quantityViewString.isEmpty()
                        || quantityViewString.equals("0")
                        || productTypeViewString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "All fields are required!!!", Toast.LENGTH_SHORT).show();
                }
                if (selectedQuantity > 0 && selectedQuantity <= selectedProduct.getQuantity()) {
                    selectedProduct.setQuantity(selectedProduct.getQuantity() - Integer.parseInt(quantityViewString));
                    // Update product data
                    productListAdapter.notifyDataSetChanged();

                    // Create dialog builder to notify user of the order
                    // Dialog is closed when touched outside or use BACK key
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    // set dialog title
                    alertDialogBuilder.setTitle("Thank You for your purchase");
                    // set dialog message
                    alertDialogBuilder.setMessage("Your purchase is " +
                            quantityViewString + " " +
                            productTypeViewString + " " + "for " +
                            String.format(Locale.CANADA, "%.2f", total));

                    alertDialogBuilder.show();

                    // Add order to history
                    History history = new History(productTypeViewString, quantityViewString, total, new Date());
                    HistoryManager hm = ((MyApp) getApplication()).getHistoryManager();
                    hm.add(history);
                }
                break;
            case R.id.manager:
                Intent intent;
                intent = new Intent(MainActivity.this, ManagerPanelActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void totalCalculationAndQuantityInStockValidate() {
        total = selectedQuantity * selectedProduct.getPrice();
        totalView.setText(String.format(Locale.CANADA, "%.2f", total));

        if (selectedQuantity > selectedProduct.getQuantity()) {
            Toast.makeText(MainActivity.this, "Not enough quantity in the stock!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
