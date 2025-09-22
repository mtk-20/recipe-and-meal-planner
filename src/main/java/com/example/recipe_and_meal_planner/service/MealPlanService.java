package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.MealPlanDto;

import java.util.List;

public interface MealPlanService {

    MealPlanDto createMealPlan(MealPlanDto dto);

    MealPlanDto getMealPlanById(Long mealId);

    List<MealPlanDto> getAllMealPlan();

    MealPlanDto updateMealPlan(Long mealId, MealPlanDto dto);

    void deleteMealPlan(Long mealId);
}
