package com.example.sagaribackend.services;

import com.example.sagaribackend.dtos.ProjectRequestDTO;
import com.example.sagaribackend.dtos.ProjectResponseDTO;
import com.example.sagaribackend.mappers.ProjectMapper;
import com.example.sagaribackend.models.Project;
import com.example.sagaribackend.models.ProjectImage;
import com.example.sagaribackend.models.ProjectTechnology;
import com.example.sagaribackend.repo.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(projectMapper::toDto)
                .toList();
    }

    public ProjectResponseDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        return projectMapper.toDto(project);
    }

    public void createProject(ProjectRequestDTO dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setGithubUrl(dto.getGithubUrl());
        project.setWebUrl(dto.getWebUrl());

        // Technologies
        List<ProjectTechnology> techs = dto.getTechnologies().stream()
                .map(name -> new ProjectTechnology(null, name, project))
                .toList();
        project.setTechnologies(techs);

        // Images
        List<ProjectImage> images = dto.getImageNames().stream()
                .map(name -> new ProjectImage(null, name, project))
                .toList();
        project.setImages(images);

        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
