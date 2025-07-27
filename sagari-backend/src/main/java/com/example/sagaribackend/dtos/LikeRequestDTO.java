package com.example.sagaribackend.dtos;

import lombok.Data;

@Data
public class LikeRequestDTO {
    private Long userId;
    private Long artId;
    private Long projectId;
}

