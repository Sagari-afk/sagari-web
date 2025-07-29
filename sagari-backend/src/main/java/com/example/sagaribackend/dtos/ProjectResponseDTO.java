package com.example.sagaribackend.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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


    public List<String> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }
}

