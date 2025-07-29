package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.TechnologyDTO;
import com.example.sagaribackend.models.Technology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    TechnologyDTO toDto(Technology tech);
    Technology toEntity(TechnologyDTO dto);
}
