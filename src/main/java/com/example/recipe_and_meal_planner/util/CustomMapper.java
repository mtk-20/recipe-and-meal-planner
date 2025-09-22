package com.example.recipe_and_meal_planner.util;

import com.example.recipe_and_meal_planner.dto.MealPlanDto;
import com.example.recipe_and_meal_planner.dto.RecipeDto;
import com.example.recipe_and_meal_planner.dto.UserDto;
import com.example.recipe_and_meal_planner.model.MealPlan;
import com.example.recipe_and_meal_planner.model.Recipe;
import com.example.recipe_and_meal_planner.model.User;
import org.springframework.stereotype.Component;

@Component
public class CustomMapper {

    public User toUserEntity(UserDto dto, String password) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        user.setPassword(password);
        return user;
    }

    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getEmail()
        );
    }

    public Recipe toRecipeEntity(RecipeDto dto, User user) {
        Recipe recipe = new Recipe();
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setDescription(dto.getDescription());
        recipe.setCategory(dto.getCategory());
        recipe.setImgUrl(dto.getImgUrl());
        recipe.setUser(user);
        return recipe;
    }

    public RecipeDto toRecipeDto(Recipe recipe) {
        return new RecipeDto(
                recipe.getRecipeId(),
                recipe.getRecipeName(),
                recipe.getDescription(),
                recipe.getCategory(),
                recipe.getImgUrl(),
                recipe.getUser().getId()
        );
    }

    public MealPlan toMealPlanEntity(MealPlanDto dto, User user, Recipe recipe) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealType(MealPlan.MealType.valueOf(dto.getMealType().toUpperCase()));
        mealPlan.setDate(dto.getDate());
        mealPlan.setUser(user);
        mealPlan.setRecipe(recipe);
        return mealPlan;
    }

    public MealPlanDto toMealPlanDto(MealPlan mealPlan) {
        return new MealPlanDto(
                mealPlan.getMealId(),
                mealPlan.getMealType().name(),
                mealPlan.getDate(),
                mealPlan.getUser().getId(),
                mealPlan.getRecipe().getRecipeId()
        );
    }
}
