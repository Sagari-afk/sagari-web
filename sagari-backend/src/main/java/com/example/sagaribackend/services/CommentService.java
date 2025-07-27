package com.example.sagaribackend.services;

import com.example.sagaribackend.dtos.CommentRequestDTO;
import com.example.sagaribackend.dtos.CommentResponseDTO;
import com.example.sagaribackend.mappers.CommentMapper;
import com.example.sagaribackend.models.AppUser;
import com.example.sagaribackend.models.Art;
import com.example.sagaribackend.models.Comment;
import com.example.sagaribackend.models.Project;
import com.example.sagaribackend.repo.ArtRepository;
import com.example.sagaribackend.repo.CommentRepository;
import com.example.sagaribackend.repo.ProjectRepository;
import com.example.sagaribackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ArtRepository artRepository;
    private final ProjectRepository projectRepository;
    private final CommentMapper commentMapper;

    public void createComment(CommentRequestDTO dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());

        AppUser user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        comment.setUser(user);

        if (dto.getArtId() != null) {
            Art art = artRepository.findById(dto.getArtId())
                    .orElseThrow(() -> new RuntimeException("Art not found"));
            comment.setArt(art);
        } else if (dto.getProjectId() != null) {
            Project project = projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Project not found"));
            comment.setProject(project);
        }

        commentRepository.save(comment);
    }

    public List<CommentResponseDTO> getCommentsForArt(Long artId) {
        return commentRepository.findByArtId(artId).stream()
                .map(commentMapper::toDto)
                .toList();
    }

    public List<CommentResponseDTO> getCommentsForProject(Long projectId) {
        return commentRepository.findByProjectId(projectId).stream()
                .map(commentMapper::toDto)
                .toList();
    }
}
