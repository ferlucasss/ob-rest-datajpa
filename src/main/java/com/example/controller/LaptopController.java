package com.example.controller;

import com.example.entities.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;


import java.util.List;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //CRUD sobre entidad laptop

    /**
     * http://localhost:8080/api/laptop
     * @return
     **/

    //Mostrar todas las laptops

    @GetMapping("/api/laptop")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    //Agregar una nueva laptop en base de datos
    @PostMapping("/api/laptop")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        //guardar la laptop recibida por parametro en la base de datos
        return laptopRepository.save(laptop);
    }





}
