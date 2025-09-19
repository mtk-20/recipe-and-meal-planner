package com.example.recipe_and_meal_planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    private long recipeId;
    private String recipeName;
    private String description;
    private String category;
    private String imgUrl;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "recipe")
    private List<MealPlan> mealPlans;
}
