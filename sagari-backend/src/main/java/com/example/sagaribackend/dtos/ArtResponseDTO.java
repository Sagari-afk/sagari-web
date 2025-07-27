package com.example.sagaribackend.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArtResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String instagramLink;
    private String imageName;
    private LocalDateTime createdAt;

    private int likeCount;
    private List<CommentResponseDTO> comments;
}

