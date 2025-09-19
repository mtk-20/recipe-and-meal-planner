package com.example.recipe_and_meal_planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
