package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.RecipeDto;
import com.example.recipe_and_meal_planner.exception.IdNotFoundException;
import com.example.recipe_and_meal_planner.model.Recipe;
import com.example.recipe_and_meal_planner.model.User;
import com.example.recipe_and_meal_planner.repo.RecipeRepo;
import com.example.recipe_and_meal_planner.repo.UserRepo;
import com.example.recipe_and_meal_planner.util.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;
    private final UserRepo userRepo;
    private final CustomMapper mapper;

    @Override
    public RecipeDto createRecipe(RecipeDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElseThrow(() -> new IdNotFoundException("No User Id " + dto.getUserId()));
        Recipe recipe = mapper.toRecipeEntity(dto, user);
        return mapper.toRecipeDto(recipeRepo.save(recipe));
    }

    @Override
    public RecipeDto getRecipeById(Long recipeId) {
        return mapper.toRecipeDto(recipeRepo.findById(recipeId).orElseThrow(() -> new IdNotFoundException("No Recipe Id" + recipeId)));
    }

    @Override
    public List<RecipeDto> getAllRecipe() {
        return recipeRepo.findAll().stream().map(mapper::toRecipeDto).collect(Collectors.toList());
    }

    @Override
    public RecipeDto updateRecipe(Long recipeId, RecipeDto dto) {
        Recipe recipe = recipeRepo.findById(recipeId).orElseThrow(() -> new IdNotFoundException("No Recipe Id" + recipeId));
        recipe.setRecipeName(dto.getRecipeName());
        recipe.setDescription(dto.getDescription());
        recipe.setCategory(dto.getCategory());
        recipe.setImgUrl(dto.getImgUrl());
        return mapper.toRecipeDto(recipeRepo.save(recipe));
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        if (!recipeRepo.existsById(recipeId)) {
            throw new IdNotFoundException("No Recipe Id" + recipeId);
        }
        recipeRepo.deleteById(recipeId);
    }
}
