package com.example.sagaribackend.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String githubUrl;
    private String webUrl;
    private LocalDateTime createdAt;

    private List<String> technologies;
    private List<String> imageNames;
    private int likeCount;
    private List<CommentResponseDTO> comments;
}

