package com.example.recipe_and_meal_planner.repo;

import com.example.recipe_and_meal_planner.model.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MealPlanRepo extends JpaRepository<MealPlan, Long> {

    List<MealPlan> findByUserIdAndDateBetween(long userId, LocalDate start, LocalDate end);
}
