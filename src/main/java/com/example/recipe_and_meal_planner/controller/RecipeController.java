package com.example.recipe_and_meal_planner.controller;

import com.example.recipe_and_meal_planner.dto.RecipeDto;
import com.example.recipe_and_meal_planner.service.RecipeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    @PostMapping("/create")
    public RecipeDto createRecipes(@RequestBody RecipeDto dto) {
        return recipeService.createRecipe(dto);
    }

    @GetMapping("/{id}")
    public RecipeDto getRecipesById(@PathVariable("id") Long id) {
        return recipeService.getRecipeById(id);
    }

    @GetMapping
    public List<RecipeDto> getAllRecipes() {
        return recipeService.getAllRecipe();
    }

    @PutMapping("/update/{id}")
    public RecipeDto updateRecipes(@PathVariable("id") Long id, @RequestBody RecipeDto dto) {
        return recipeService.updateRecipeById(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecipes(@PathVariable("id") Long id) {
        recipeService.deleteRecipe(id);
    }
}
