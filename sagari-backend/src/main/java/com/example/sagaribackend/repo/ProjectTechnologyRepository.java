package com.example.sagaribackend.repo;

import com.example.sagaribackend.models.Project;
import com.example.sagaribackend.models.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectTechnologyRepository extends JpaRepository<Technology, Long> {

    List<Technology> findByProjects(List<Project> project);

    Optional<Technology> findByTechnologyName(String technologyName);
}
