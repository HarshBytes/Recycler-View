package com.example.exitosystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_carview extends RecyclerView.Adapter<Adapter_carview.Viewholder> {
    Context context;
    ArrayList<Cars> arrayList;
    Adapter_carview(Context context, ArrayList<Cars> arrayList){
     this.context=context;
     this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cars_row,parent,false);
        Viewholder viewholder=new Viewholder(v);
        return viewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.car_Name.setText(arrayList.get(position).car_name);
        holder.car_Manufacturer.setText(arrayList.get(position).car_Manufacturer);
        holder.car_Model.setText(arrayList.get(position).car_model);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Details.class);
                intent.putExtra("Name",arrayList.get(holder.getAdapterPosition()).getCar_name());
                intent.putExtra("Manufacturer",arrayList.get(holder.getAdapterPosition()).getCar_Manufacturer());
                intent.putExtra("Model",arrayList.get(holder.getAdapterPosition()).getCar_model());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView car_Name,car_Manufacturer,car_Model;
        CardView cardView;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            car_Name=itemView.findViewById(R.id.car_name);
            car_Manufacturer=itemView.findViewById(R.id.car_manufacturer);
            car_Model=itemView.findViewById(R.id.car_model);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
