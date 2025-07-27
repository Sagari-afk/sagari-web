package com.example.sagaribackend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ProjectRequestDTO {
    private String name;
    private String description;
    private String githubUrl;
    private String webUrl;

    private List<String> technologies;
    private List<String> imageNames;
}

