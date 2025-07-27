package com.example.sagaribackend.repo;

import com.example.sagaribackend.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArtId(Long artId);
    List<Comment> findByProjectId(Long projectId);
}
