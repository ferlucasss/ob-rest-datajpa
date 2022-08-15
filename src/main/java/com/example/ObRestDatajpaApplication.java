package com.example;

import com.example.entities.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		//CRUD
		// crear laptop
		Laptop laptop1 = new Laptop(null, "Asus", "1TB", "Windows 10", "color blanco", 400d, LocalDate.of(2017, 4, 9), true);
		Laptop laptop2 = new Laptop(null, "DELL", "2TB", "Windows 10", "color negro", 700d, LocalDate.of(2016, 2, 3), true);

		repository.save(laptop1);
		repository.save(laptop2);
	}

}
