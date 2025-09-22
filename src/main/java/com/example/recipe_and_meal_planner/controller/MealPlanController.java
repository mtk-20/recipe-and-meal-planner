package com.example.recipe_and_meal_planner.controller;

import com.example.recipe_and_meal_planner.dto.MealPlanDto;
import com.example.recipe_and_meal_planner.service.MealPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meal-plan")
public class MealPlanController {

    private final MealPlanService mealPlanService;

    @PostMapping("/create")
    public MealPlanDto createMealPlans(@RequestBody MealPlanDto dto) {
        return mealPlanService.createMealPlan(dto);
    }

    @GetMapping("/{id}")
    public MealPlanDto getMealPlansById(@PathVariable("id") Long id) {
        return mealPlanService.getMealPlanById(id);
    }

    @GetMapping
    public List<MealPlanDto> getAllMealPlans() {
        return mealPlanService.getAllMealPlan();
    }

    @PutMapping("/update/{id}")
    public MealPlanDto updateMealPlans(@PathVariable("id") Long id, @RequestBody MealPlanDto dto) {
        return mealPlanService.updateMealPlan(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMealPlans(@PathVariable("id") Long id) {
        mealPlanService.deleteMealPlan(id);
    }
}
