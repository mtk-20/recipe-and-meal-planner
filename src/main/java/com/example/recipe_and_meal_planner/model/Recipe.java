package com.example.recipe_and_meal_planner.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeId;

    private String recipeName;

    @Column(length = 3000)
    private String description;
    private String category;
    private String imgUrl;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "recipe")
    private List<MealPlan> mealPlans;
}
