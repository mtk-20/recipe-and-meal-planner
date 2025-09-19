package com.example.recipe_and_meal_planner.repo;

import com.example.recipe_and_meal_planner.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {

    List<Recipe> findByUserId(long userId);
}
