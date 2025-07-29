package com.example.sagaribackend.services;

import com.example.sagaribackend.dtos.ProjectRequestDTO;
import com.example.sagaribackend.dtos.ProjectResponseDTO;
import com.example.sagaribackend.mappers.ProjectMapper;
import com.example.sagaribackend.models.Project;
import com.example.sagaribackend.models.ProjectImage;
import com.example.sagaribackend.models.Technology;
import com.example.sagaribackend.repo.ProjectRepository;
import com.example.sagaribackend.repo.ProjectTechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    private final ProjectTechnologyRepository projectTechnologyRepository;

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
        List<Technology> technologies = dto.getTechnologies().stream()
                .map(techName -> projectTechnologyRepository.findByTechnologyName(techName)
                        .orElseGet(() -> {
                            Technology newTech = new Technology();
                            newTech.setTechnologyName(techName);


                            return projectTechnologyRepository.save(newTech);
                        }))
                .toList();
        project.setTechnologies(technologies);

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
