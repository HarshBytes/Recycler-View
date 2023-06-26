package com.example.exitosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
TextView car_name,car_Manufacturer,car_model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        car_name=findViewById(R.id.car_name);
        car_Manufacturer=findViewById(R.id.car_manufacturer);
        car_model=findViewById(R.id.car_model);


        car_name.setText(getIntent().getStringExtra("Name"));
        car_Manufacturer.setText(getIntent().getStringExtra("Manufacturer"));
        car_model.setText(getIntent().getStringExtra("Model"));

    }
}