package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.MealPlanDto;
import com.example.recipe_and_meal_planner.exception.IdNotFoundException;
import com.example.recipe_and_meal_planner.model.MealPlan;
import com.example.recipe_and_meal_planner.model.Recipe;
import com.example.recipe_and_meal_planner.model.User;
import com.example.recipe_and_meal_planner.repo.MealPlanRepo;
import com.example.recipe_and_meal_planner.repo.RecipeRepo;
import com.example.recipe_and_meal_planner.repo.UserRepo;
import com.example.recipe_and_meal_planner.util.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealPlanServiceImpl implements MealPlanService {

    private final MealPlanRepo mealPlanRepo;
    private final RecipeRepo recipeRepo;
    private final UserRepo userRepo;
    private final CustomMapper mapper;

    @Override
    public MealPlanDto createMealPlan(MealPlanDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow(() -> new IdNotFoundException("No User Id " + dto.getUserId()));
        Recipe recipe = recipeRepo.findById(dto.getRecipeId()).orElseThrow(() -> new IdNotFoundException("No User Id " + dto.getRecipeId()));
        MealPlan mealPlan = mapper.toMealPlanEntity(dto, user, recipe);
        return mapper.toMealPlanDto(mealPlanRepo.save(mealPlan));
    }

    @Override
    public MealPlanDto getMealPlanById(Long mealId) {
        return mapper.toMealPlanDto(mealPlanRepo.findById(mealId).orElseThrow(() -> new IdNotFoundException("No User Id " + mealId)));
    }

    @Override
    public List<MealPlanDto> getAllMealPlan() {
        return mealPlanRepo.findAll().stream().map(mapper::toMealPlanDto).collect(Collectors.toList());
    }

    @Override
    public MealPlanDto updateMealPlan(Long mealId, MealPlanDto dto) {
        MealPlan mealPlan = mealPlanRepo.findById(mealId).orElseThrow(() -> new IdNotFoundException("No User Id " + mealId));
        mealPlan.setMealType(MealPlan.MealType.valueOf(dto.getMealType()));
        mealPlan.setDate(dto.getDate());
        return mapper.toMealPlanDto(mealPlanRepo.save(mealPlan));
    }

    @Override
    public void deleteMealPlan(Long mealId) {
        if (!mealPlanRepo.existsById(mealId)) {
            throw new IdNotFoundException("No Meal Id " + mealId);
        }
        mealPlanRepo.deleteById(mealId);
    }
}
