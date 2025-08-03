package com.example.sagaribackend.controllers;

import com.example.sagaribackend.dtos.CommentRequestDTO;
import com.example.sagaribackend.dtos.LikeRequestDTO;
import com.example.sagaribackend.dtos.ProjectRequestDTO;
import com.example.sagaribackend.dtos.ProjectResponseDTO;
import com.example.sagaribackend.services.CommentService;
import com.example.sagaribackend.services.LikeService;
import com.example.sagaribackend.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final LikeService likeService;
    private final CommentService commentService;

    @GetMapping
    public List<ProjectResponseDTO> getAll() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProjectRequestDTO dto) {
        projectService.createProject(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/like")
    public ResponseEntity<?> likeProject(@RequestBody LikeRequestDTO dto) {
        try {
            likeService.likeProject(dto.getUserId(), dto.getProjectId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());         // TODO: logger class
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlikeProject(@RequestBody LikeRequestDTO dto) {
        likeService.unlikeProject(dto.getUserId(), dto.getProjectId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/comment")
    public ResponseEntity<?> comment(@RequestBody CommentRequestDTO dto) {
        commentService.createComment(dto);
        return ResponseEntity.ok().build();
    }
}