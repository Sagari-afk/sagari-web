package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.ProjectRequestDTO;
import com.example.sagaribackend.dtos.ProjectResponseDTO;
import com.example.sagaribackend.models.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface ProjectMapper {

    @Mapping(target = "technologies", source = "technologies")
    @Mapping(target = "imageNames", expression = "java(project.getImages().stream().map(ProjectImage::getImageName).toList())")
    @Mapping(target = "likeCount", expression = "java(project.getLikes() != null ? project.getLikes().size() : 0)")
    ProjectResponseDTO toDto(Project project);

    @Mapping(target = "technologies", ignore = true)
    @Mapping(target = "images", ignore = true)
    Project toEntity(ProjectRequestDTO dto);
}
