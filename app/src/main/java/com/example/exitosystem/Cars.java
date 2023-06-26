package com.example.exitosystem;

public class Cars {
    String car_name;
    String car_Manufacturer;
    String car_model;

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_Manufacturer() {
        return car_Manufacturer;
    }

    public void setCar_Manufacturer(String car_Manufacturer) {
        this.car_Manufacturer = car_Manufacturer;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }



    public Cars(String car_name, String car_Manufacturer, String car_model) {
        this.car_name = car_name;
        this.car_Manufacturer = car_Manufacturer;
        this.car_model = car_model;
    }


}
