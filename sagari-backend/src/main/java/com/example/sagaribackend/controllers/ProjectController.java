package com.example.sagaribackend.controllers;

import com.example.sagaribackend.dtos.ProjectRequestDTO;
import com.example.sagaribackend.dtos.ProjectResponseDTO;
import com.example.sagaribackend.mappers.ProjectMapper;
import com.example.sagaribackend.models.AppUser;
import com.example.sagaribackend.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    @GetMapping
    public List<ProjectResponseDTO> getAll() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProjectRequestDTO dto) {
        projectService.createProject(dto);
        return ResponseEntity.ok().build();
    }
}