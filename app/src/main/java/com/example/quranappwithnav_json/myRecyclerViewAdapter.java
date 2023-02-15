package com.example.quranappwithnav_json;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.MyVH> {
    ArrayList<select> logs;
    Context context;

    public myRecyclerViewAdapter(ArrayList<select> dataHolder, Context context) {
        this.logs=dataHolder;
        this.context=context;
    }

    public myRecyclerViewAdapter(ArrayList<select> dataHolder) {
        this.logs=dataHolder;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singlerow, parent, false);
        return new MyVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.data=logs.get(position);
        holder.format.setText(holder.data.format);
        if(holder.data.format.equals("parah"))
            holder.name.setText(String.valueOf((holder.data.number)));
        else
            holder.name.setText(String.valueOf((holder.data.name)));




    }

    @Override
    public int getItemCount() {
        return logs.size();
    }

    public class MyVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView format;
        TextView  name;
        select data;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener( this);
            context = itemView.getContext();
            format = itemView.findViewById(R.id.NameView);
            name = itemView.findViewById(R.id.number);

        }

        @Override
        public void onClick(View view) {
            android.util.Log.d("Clicked","RecyleView");
            int position=this.getAdapterPosition();
            select data=logs.get(position);
            android.util.Log.d("Clicked",""+data);
            String format= (data.format);
            Integer number=data.number;
            android.util.Log.d("Clicked","RecyleView"+number);
            String name= data.name;


            Intent intent = new Intent(context,displayAyah.class);
            intent.putExtra("name", name);
            intent.putExtra("format", format);
            intent.putExtra("number",number.toString());
            context.startActivity(intent);

        }

    }
}
