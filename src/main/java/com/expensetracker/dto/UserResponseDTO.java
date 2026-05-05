package com.expensetracker.dto;

import java.time.LocalDateTime;


public record UserResponseDTO(

        Integer id,
        String name,
        String email,
        LocalDateTime createdAt

) {}