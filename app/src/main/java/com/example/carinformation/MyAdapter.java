package com.example.carinformation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {

    ArrayList<Car> list;
    Context context;

    public MyAdapter (Context context, ArrayList<Car> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new myViewHolder(view);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.ivLogo.setImageResource(list.get(position).logo);
        holder.tvModel.setText(list.get(position).model);
        holder.tvOwnerName.setText(list.get(position).ownerName);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        ImageView ivLogo;
        TextView tvModel, tvOwnerName;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            ivLogo = itemView.findViewById(R.id.ivLogo_r);
            tvModel = itemView.findViewById(R.id.tvModel_r);
            tvOwnerName = itemView.findViewById(R.id.tvOwnerName_r);


        }
    }
}
