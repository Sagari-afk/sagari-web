package com.example.sagaribackend.mappers;

import com.example.sagaribackend.dtos.ProjectRequestDTO;
import com.example.sagaribackend.dtos.ProjectResponseDTO;
import com.example.sagaribackend.models.Project;
import com.example.sagaribackend.models.ProjectImage;
import com.example.sagaribackend.models.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface ProjectMapper {

    @Mapping(target = "technologies", source = "technologies")
    @Mapping(target = "imageNames", source = "images")
    @Mapping(target = "likeCount", expression = "java(project.getLikes() != null ? project.getLikes().size() : 0)")
    ProjectResponseDTO toDto(Project project);

    @Mapping(target = "technologies", ignore = true)
    @Mapping(target = "images", ignore = true)
    Project toEntity(ProjectRequestDTO dto);

    default List<String> map(List<Technology> technologies) {
        if (technologies == null) return java.util.Collections.emptyList();
        return technologies.stream()
                .map(Technology::getTechnologyName)
                .toList();
    }

    default List<String> mapImages(List<ProjectImage> images) {
        if (images == null) return Collections.emptyList();
        return images.stream().map(ProjectImage::getImageName).toList();
    }


}
