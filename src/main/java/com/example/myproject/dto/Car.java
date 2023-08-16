package com.example.myproject.dto;

public class Car {
    String model;
    String price;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
