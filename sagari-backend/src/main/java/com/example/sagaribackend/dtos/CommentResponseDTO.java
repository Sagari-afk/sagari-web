package com.example.sagaribackend.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponseDTO {
    private Long id;
    private String text;
    private LocalDateTime createdAt;

    private UserResponseDTO user;
}

