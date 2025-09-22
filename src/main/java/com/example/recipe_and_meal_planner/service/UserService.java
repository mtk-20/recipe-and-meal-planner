package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.UserDto;
import com.example.recipe_and_meal_planner.exception.IdNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto dto, String password);

    UserDto getUserById(Long id);

    List<UserDto> getAllUser();

    UserDto updateUser(Long id, UserDto dto);

    void deleteUser(Long id);
}
