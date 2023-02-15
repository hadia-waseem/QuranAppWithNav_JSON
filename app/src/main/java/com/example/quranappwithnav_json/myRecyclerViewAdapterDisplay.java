package com.example.quranappwithnav_json;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyclerViewAdapterDisplay extends RecyclerView.Adapter<myRecyclerViewAdapterDisplay.MyVH> {
    ArrayList<ayah> logs;
    Context context;

    public myRecyclerViewAdapterDisplay(ArrayList<ayah> dataHolder, Context context) {
        this.logs=dataHolder;
        this.context=context;
    }

    public myRecyclerViewAdapterDisplay(ArrayList<ayah> dataHolder) {
        this.logs=dataHolder;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.displayrow, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=logs.get(position);
        holder.surahName.setText(String.valueOf((holder.data.SurahName)));
        holder.text.setText(String.valueOf(holder.data.Text));



    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    public class MyVH extends RecyclerView.ViewHolder  {

        TextView surahName;
        TextView  text;
        ayah data;

        public MyVH(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();
            surahName = itemView.findViewById(R.id.surahName);
            text = itemView.findViewById(R.id.Ayah);

        }


    }
}
