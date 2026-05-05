package com.expensetracker.dto;

import com.expensetracker.entities.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(user.getId(),user.getName(),user.getEmail(), user.getCreatedAt());
    }


    public User toEntity(RegisterRequestDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }
}