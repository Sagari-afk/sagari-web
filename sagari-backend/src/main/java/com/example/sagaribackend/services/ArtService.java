package com.example.sagaribackend.services;

import com.example.sagaribackend.dtos.ArtRequestDTO;
import com.example.sagaribackend.dtos.ArtResponseDTO;
import com.example.sagaribackend.mappers.ArtMapper;
import com.example.sagaribackend.models.Art;
import com.example.sagaribackend.repo.ArtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArtService {

    private final ArtRepository artRepository;
    private final ArtMapper artMapper;

    public List<ArtResponseDTO> getAllArts() {
        return artRepository.findAll().stream()
                .map(artMapper::toDto)
                .toList();
    }

    public ArtResponseDTO getArtById(Long id) {
        Art art = artRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Art not found"));
        return artMapper.toDto(art);
    }

    public void createArt(ArtRequestDTO dto) {
        Art art = artMapper.toEntity(dto);
        artRepository.save(art);
    }

    public void deleteArt(Long id) {
        artRepository.deleteById(id);
    }
}
