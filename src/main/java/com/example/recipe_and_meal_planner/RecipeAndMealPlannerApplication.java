package com.example.recipe_and_meal_planner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class RecipeAndMealPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeAndMealPlannerApplication.class, args);
	}

}
