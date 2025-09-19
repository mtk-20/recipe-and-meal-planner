package com.example.recipe_and_meal_planner.repo;

import com.example.recipe_and_meal_planner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
