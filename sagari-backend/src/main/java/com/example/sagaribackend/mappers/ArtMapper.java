package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.ArtRequestDTO;
import com.example.sagaribackend.dtos.ArtResponseDTO;
import com.example.sagaribackend.models.Art;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface ArtMapper {

    @Mapping(target = "likeCount", expression = "java(art.getLikes() != null ? art.getLikes().size() : 0)")
    ArtResponseDTO toDto(Art art);

    Art toEntity(ArtRequestDTO dto);
}

