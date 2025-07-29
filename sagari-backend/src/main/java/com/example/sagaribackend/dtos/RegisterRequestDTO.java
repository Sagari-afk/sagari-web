package com.example.sagaribackend.dtos;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String email;
    private String userName;
    private String password;
}