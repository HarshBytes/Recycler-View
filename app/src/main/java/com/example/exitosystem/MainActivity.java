package com.example.exitosystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Cars> arrayList =new ArrayList<>();
    FloatingActionButton Add_Car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Cars("Audi Q3","Volkswagen Group","2012"));
        arrayList.add(new Cars("Mercedes Benz ","Group AG","2022"));
        arrayList.add(new Cars("Land Rover","Tata Moters","2008"));
        arrayList.add(new Cars("BMW X5","Plant Spartanburg","2003"));
        arrayList.add(new Cars("Porsche","Volkswagen Group","2012"));
        arrayList.add(new Cars("Rolls Royce","BMW Group","2012"));

        Adapter_carview adapterCarview=new Adapter_carview(this,arrayList);
        recyclerView.setAdapter(adapterCarview);
        Add_Car=findViewById(R.id.button);
        Add_Car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText car_name,car_Manufacturer,car_model;
                Button Save,Cancel;
                Dialog dialog=new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_car);
                car_name=dialog.findViewById(R.id.Name);
                car_Manufacturer=dialog.findViewById(R.id.Manufacturer);
                car_model=dialog.findViewById(R.id.Model);
                Save=dialog.findViewById(R.id.Save);
                Cancel=dialog.findViewById(R.id.Cancel);

                Save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String Name=car_name.getText().toString();
                        String Manufacturer=car_Manufacturer.getText().toString();
                        String Model=car_model.getText().toString();

                        arrayList.add(new Cars(Name,Manufacturer,Model));
                        adapterCarview.notifyItemInserted(arrayList.size()-1);
                        recyclerView.scrollToPosition(arrayList.size()-1);
                        dialog.dismiss();
                    }
                });
                dialog.show();
                Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });

    }
}