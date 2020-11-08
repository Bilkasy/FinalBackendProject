package com.example.FoodProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.FoodProject.model"})
@EnableJpaRepositories("com.example.FoodProject.repositories")

public class FoodProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodProjectApplication.class, args);
	}

}
