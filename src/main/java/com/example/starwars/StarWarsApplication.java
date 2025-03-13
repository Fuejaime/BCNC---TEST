package com.example.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.starwars",
		"com.example.starwars.domain.repository"
})


public class StarWarsApplication {
	public static void main(String[] args) {
		SpringApplication.run(StarWarsApplication.class, args);
	}

}
