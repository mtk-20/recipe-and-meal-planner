package com.example.recipe_and_meal_planner.controller;

import com.example.recipe_and_meal_planner.dto.UserDto;
import com.example.recipe_and_meal_planner.dto.UserResponseDto;
import com.example.recipe_and_meal_planner.exception.IdNotFoundException;
import com.example.recipe_and_meal_planner.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/create")
    public UserDto createUsers(@RequestBody UserDto dto, @RequestParam String password) {
        return userService.createUser(dto, password);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUsersById(@PathVariable("id") long id) throws IdNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserResponseDto> getAlUsers() {
        return userService.getAllUser();
    }

    @PutMapping("/update/{id}")
    public UserDto updateUsers(@PathVariable("id") Long id,@RequestBody UserDto dto) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsers(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

}
