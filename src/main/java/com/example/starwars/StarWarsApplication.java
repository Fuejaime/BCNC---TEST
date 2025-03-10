package com.example.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.starwars", // Paquete base para escaneo automático
		"com.example.starwars.domain.repository"// Paquete específico donde está el mapper
})
public class StarWarsApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
		String dateString = "01-02-2021";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		try {
			LocalDate date = LocalDate.parse(dateString, formatter);
			System.out.println("Parsed date: " + date);
		} catch (DateTimeParseException e) {
			System.out.println("Date parsing error: " + e.getMessage());
		}
	}

}
