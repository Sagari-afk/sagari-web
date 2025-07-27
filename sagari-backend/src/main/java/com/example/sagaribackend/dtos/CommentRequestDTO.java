package com.example.sagaribackend.dtos;

import lombok.Data;

@Data
public class CommentRequestDTO {
    private String text;
    private Long userId;

    private Long artId;
    private Long projectId;
}
