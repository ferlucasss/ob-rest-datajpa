package com.example.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String memory;
    private String os;
    private String description;
    private Double price;
    private LocalDate releaseDate;
    private Boolean stock;

    public Laptop() {
    }

    public Laptop(Long id, String name, String memory, String os, String description, Double price, LocalDate releaseDate, Boolean stock) {
        this.id = id;
        this.name = name;
        this.memory = memory;
        this.os = os;
        this.description = description;
        this.price = price;
        this.releaseDate = releaseDate;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getStock() {
        return stock;
    }

    public void setStock(Boolean stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", memory='" + memory + '\'' +
                ", os='" + os + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", stock=" + stock +
                '}';
    }
}
