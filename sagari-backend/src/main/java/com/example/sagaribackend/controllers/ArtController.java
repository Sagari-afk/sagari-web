package com.example.sagaribackend.controllers;

import com.example.sagaribackend.dtos.ArtRequestDTO;
import com.example.sagaribackend.dtos.ArtResponseDTO;
import com.example.sagaribackend.mappers.ArtMapper;
import com.example.sagaribackend.services.ArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/art")
@RequiredArgsConstructor
public class ArtController {
    private final ArtService artService;
    private final ArtMapper artMapper;

    @GetMapping
    public List<ArtResponseDTO> getAll() {
        return artService.getAllArts();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ArtRequestDTO dto) {
        artService.createArt(dto);
        return ResponseEntity.ok().build();
    }
}