package com.example.sagaribackend.dtos;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String imageName;
}
