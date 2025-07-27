package com.example.sagaribackend.repo;

import com.example.sagaribackend.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    boolean existsByUserIdAndArtId(Long userId, Long artId);
    boolean existsByUserIdAndProjectId(Long userId, Long projectId);

    long countByArtId(Long artId);
    long countByProjectId(Long projectId);

    void deleteByUserIdAndArtId(Long userId, Long artId);
    void deleteByUserIdAndProjectId(Long userId, Long projectId);
}
