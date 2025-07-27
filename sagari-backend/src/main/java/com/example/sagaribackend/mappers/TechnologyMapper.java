package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.TechnologyDTO;
import com.example.sagaribackend.models.ProjectTechnology;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    TechnologyDTO toDto(ProjectTechnology tech);
    ProjectTechnology toEntity(TechnologyDTO dto);
}
