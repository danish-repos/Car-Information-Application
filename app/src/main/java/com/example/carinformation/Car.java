package com.example.carinformation;

import android.widget.ImageView;

public class Car {

    int logo;
    String model;
    String ownerName;
    String phoneNumber;


    public Car(int logo, String model, String ownerName, String phoneNumber) {
        this.logo = logo;
        this.model = model;
        this.ownerName = ownerName;
        this.phoneNumber = phoneNumber;
    }

    public int getImg() {
        return logo;
    }

    public void setImg(int logo) {
        this.logo = logo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "logo=" + logo +
                ", model='" + model + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
