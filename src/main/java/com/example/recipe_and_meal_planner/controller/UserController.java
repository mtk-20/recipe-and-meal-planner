package com.example.recipe_and_meal_planner.controller;

import com.example.recipe_and_meal_planner.dto.UserDto;
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
    public UserDto createUser(@RequestBody UserDto dto, @RequestParam String password) {
        return userService.createUser(dto, password);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") long id) throws IdNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDto> getAlUsers() {
        return userService.getAllUser();
    }

}
