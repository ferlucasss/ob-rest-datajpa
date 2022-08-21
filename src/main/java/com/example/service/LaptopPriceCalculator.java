package com.example.service;

import com.example.entities.Laptop;

public class LaptopPriceCalculator {

    public double calculatePrice(Laptop laptop){

        double price = laptop.getPrice();

        if (laptop.getPrice() > 300){
            price += 5;
        }

        return price;

    }

}
