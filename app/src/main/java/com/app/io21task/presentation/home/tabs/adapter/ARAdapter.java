package com.app.io21task.presentation.home.tabs.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.app.io21task.R;

import java.util.ArrayList;

public class ARAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    ArrayList<String> list = new ArrayList<>();

    public ARAdapter(Context context, ArrayList<String> list) { // you can pass other parameters in constructor
        this.context = context;
        this.list = list;
    }

    private class CustomAdapterItemView extends RecyclerView.ViewHolder {

        CustomAdapterItemView(final View itemView) {
            super(itemView);
        }

        void bind(int position) {
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomAdapterItemView(LayoutInflater.from(context).inflate(R.layout.item_list_ar, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CustomAdapterItemView) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    // Add your other methods here
}