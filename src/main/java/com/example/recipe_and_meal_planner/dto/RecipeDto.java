package com.example.recipe_and_meal_planner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDto {

    private Long recipeId;
    private String recipeName;
    private String description;
    private String category;
    private String imgUrl;
    private Long userId;
}
