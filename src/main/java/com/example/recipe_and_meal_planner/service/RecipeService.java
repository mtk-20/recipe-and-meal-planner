package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    RecipeDto createRecipe(RecipeDto dto);

    RecipeDto getRecipeById(Long recipeId);

    List<RecipeDto> getAllRecipe();

    RecipeDto updateRecipeById(Long recipeId, RecipeDto dto);

    void deleteRecipe(Long recipeId);
}
