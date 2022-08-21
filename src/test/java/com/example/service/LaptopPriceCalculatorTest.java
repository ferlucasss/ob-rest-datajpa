package com.example.service;

import com.example.entities.Laptop;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LaptopPriceCalculatorTest {

    @Test
    void calculatePrice() {
        //config de la prueba
        Laptop laptop = new Laptop(null, "Asus", "1TB", "Windows 10", "color blanco", 400d, LocalDate.of(2017, 4, 9), true);
        LaptopPriceCalculator calculator = new LaptopPriceCalculator();

        //Ejecutamos comportamiento a testear
        double price = calculator.calculatePrice(laptop);
        System.out.println(price);

        //comprobaciones aserciones
        assertTrue(price > 0);
    }
}