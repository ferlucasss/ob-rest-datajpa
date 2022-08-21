package com.example.controller;

import com.example.entities.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //Atributos
    private LaptopRepository laptopRepository;
    //Constructores
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

    //Buscar laptop por id
    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent()) {
            return ResponseEntity.ok(laptopOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    //Agregar una nueva laptop en base de datos
    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));
        //guardar la laptop recibida por parametro en la base de datos
        if (laptop.getId() != null) {   // quiere decir que existe el id y por tanto no es una creación
            log.warn("trying to create a laptop with id");
            System.out.println("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }

        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);

    }

    //Actualizar una laptop existente en base de datos
    @PutMapping("/api/laptop")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if (laptop.getId() == null){ // quiere decir que es una creacion
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //Borrar laptop por id de la base de datos
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
        if (!laptopRepository.existsById(id)){
            log.warn("Trying delete a nonexistent laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar todas las laptop de la base de datos
    @DeleteMapping("/api/laptop")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("Deleting all");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }








}
