package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.UserDto;
import com.example.recipe_and_meal_planner.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto dto, String password);

    UserResponseDto getUserById(Long id);

    List<UserResponseDto> getAllUser();

    UserDto updateUser(Long id, UserDto dto);

    void deleteUser(Long id);
}
