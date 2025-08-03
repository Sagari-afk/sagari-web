package com.example.sagaribackend.controllers;

import com.example.sagaribackend.dtos.ArtRequestDTO;
import com.example.sagaribackend.dtos.ArtResponseDTO;
import com.example.sagaribackend.dtos.CommentRequestDTO;
import com.example.sagaribackend.dtos.LikeRequestDTO;
import com.example.sagaribackend.mappers.ArtMapper;
import com.example.sagaribackend.repo.ArtRepository;
import com.example.sagaribackend.services.ArtService;
import com.example.sagaribackend.services.CommentService;
import com.example.sagaribackend.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/art")
@RequiredArgsConstructor
public class ArtController {
    private final ArtService artService;
    private final LikeService  likeService;
    private final CommentService commentService;

    @GetMapping
    public List<ArtResponseDTO> getAll() {
        return artService.getAllArts();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ArtRequestDTO dto) {
        artService.createArt(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/like")
    public ResponseEntity<?> likeArt(@RequestBody LikeRequestDTO dto) {
        try {
            likeService.likeArt(dto.getUserId(), dto.getArtId());
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/unlike")
    public ResponseEntity<?> unlikeArt(@RequestBody LikeRequestDTO dto) {
        likeService.unlikeArt(dto.getUserId(), dto.getArtId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/comment")
    public ResponseEntity<?> comment(@RequestBody CommentRequestDTO dto) {
        commentService.createComment(dto);
        return ResponseEntity.ok().build();
    }
}