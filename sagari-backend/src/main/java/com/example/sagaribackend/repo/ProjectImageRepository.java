package com.example.sagaribackend.repo;

import com.example.sagaribackend.models.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Long> {

    List<ProjectImage> findByProjectId(Long projectId);
}
