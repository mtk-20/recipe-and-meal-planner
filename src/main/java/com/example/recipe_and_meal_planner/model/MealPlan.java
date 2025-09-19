package com.example.recipe_and_meal_planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data@NoArgsConstructor@AllArgsConstructor
public class MealPlan {

    private long mealId;
    private MealType mealType;
    private LocalDate date;

    private enum MealType {
        breakfast, lunch, dinner
    }

    @ManyToOne
    private User user;

    @ManyToOne
    private Recipe recipe;

}
