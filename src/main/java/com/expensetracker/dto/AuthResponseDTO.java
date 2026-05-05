package com.expensetracker.dto;


public record AuthResponseDTO(

        String token,
        String type,
        UserResponseDTO user

) {
   
}