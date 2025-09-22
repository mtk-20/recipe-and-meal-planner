package com.example.recipe_and_meal_planner.service;

import com.example.recipe_and_meal_planner.dto.UserDto;
import com.example.recipe_and_meal_planner.exception.IdNotFoundException;
import com.example.recipe_and_meal_planner.model.User;
import com.example.recipe_and_meal_planner.repo.UserRepo;
import com.example.recipe_and_meal_planner.util.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final CustomMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto dto, String password) {
        String encoded = passwordEncoder.encode(password);
        User user = mapper.toUserEntity(dto, encoded);
        return mapper.toUserDto(userRepo.save(user));
    }

    @Override
    public UserDto getUserById(Long id) {
        return mapper.toUserDto(userRepo.findById(id).orElseThrow(() -> new IdNotFoundException("No User Id - " + id)));
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepo.findAll().stream().map(mapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id, UserDto dto) {
        User user = userRepo.findById(id).orElseThrow(() -> new IdNotFoundException("No User Id - " + id));
        user.setUserName(dto.getUserName());
        user.setEmail(dto.getEmail());
        return mapper.toUserDto(userRepo.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepo.existsById(id)) {
            throw new IdNotFoundException("No User Id - " + id);
        }
        userRepo.deleteById(id);
    }


}
