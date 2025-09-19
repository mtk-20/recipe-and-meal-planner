package com.example.recipe_and_meal_planner.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealPlanDto {

    private Long mealId;
    private String mealType;
    private LocalDate date;
    private Long userId;
    private Long recipeId;
}
