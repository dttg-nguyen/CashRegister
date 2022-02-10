package com.example.cashregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder> {
    Context context;
    List<History> historyList;

    public HistoryRecyclerViewAdapter(Context context, List<History> historyList){
        this.context = context;
        this.historyList = historyList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_list_item_recyclerview, null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Retrieve date for that position
        History history = historyList.get(position);
        // Add date to the view
        holder.product.setText(history.productName);
        holder.quantity.setText(history.quantity);
        holder.total.setText(String.format("%.2f", history.totalPrice));
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView product;
        private final TextView quantity;
        private final TextView total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product = itemView.findViewById(R.id.history_product);
            quantity = itemView.findViewById(R.id.history_quantity);
            total = itemView.findViewById(R.id.history_total);
        }
    }
}
