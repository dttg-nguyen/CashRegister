package com.example.cashregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductListBaseAdapter extends BaseAdapter {
    private Context context;
    public List<Product> products;

    public ProductListBaseAdapter(Context context, List<Product> products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        // inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_layout_baseadapter, null);
        }

        Product currentProduct = (Product) getItem(position);

        TextView product_name = view.findViewById(R.id.productList_name);
        TextView product_quantity = view.findViewById(R.id.productList_quantity);
        TextView product_price = view.findViewById(R.id.productList_price);

        product_name.setText(currentProduct.name);
        product_quantity.setText(String.valueOf(currentProduct.quantity));
        product_price.setText(String.valueOf(currentProduct.price));

        return view;
    }
}
