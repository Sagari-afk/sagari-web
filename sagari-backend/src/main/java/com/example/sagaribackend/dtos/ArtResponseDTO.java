package com.example.sagaribackend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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

