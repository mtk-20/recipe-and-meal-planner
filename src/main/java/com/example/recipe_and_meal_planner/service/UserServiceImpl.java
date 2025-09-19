package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.UserDto;
import com.example.recipe_and_meal_planner.exception.IdNotFoundException;
import com.example.recipe_and_meal_planner.model.User;
import com.example.recipe_and_meal_planner.repo.UserRepo;
import com.example.recipe_and_meal_planner.util.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final CustomMapper mapper;
    private final PasswordEncoder passwordEncoder;

    // userRepo.findById(dto.getId()).orElseThrow(() -> new IdNotFoundException("No user id " + dto.getId()))
    @Override
    public UserDto createUser(UserDto dto, String password) {
        String encoded = passwordEncoder.encode(password);
        User user = mapper.toUserEntity(dto, encoded);
        return mapper.toUserDto(userRepo.save(user));
    }

    @Override
    public Optional<UserDto> getUserById(Long id) throws IdNotFoundException {
        if (!userRepo.existsById(id)) {
            throw new IdNotFoundException("No user id " + id);
        }
        return userRepo.findById(id).map(mapper::toUserDto);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepo.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }


}
