package com.example.sagaribackend.services;

import com.example.sagaribackend.models.AppUser;
import com.example.sagaribackend.models.Art;
import com.example.sagaribackend.models.Like;
import com.example.sagaribackend.models.Project;
import com.example.sagaribackend.repo.ArtRepository;
import com.example.sagaribackend.repo.LikeRepository;
import com.example.sagaribackend.repo.ProjectRepository;
import com.example.sagaribackend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final ArtRepository artRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public void likeArt(Long userId, Long artId) {
        if (likeRepository.existsByUserIdAndArtId(userId, artId))
            throw new RuntimeException("The user already liked this art");

        Art art = artRepository.findById(artId)
                .orElseThrow(() -> new RuntimeException("Art not found"));
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Like like = new Like();
        like.setUser(user);
        like.setArt(art);

        likeRepository.save(like);
    }

    public void likeProject(Long userId, Long projectId) {
        if (likeRepository.existsByUserIdAndProjectId(userId, projectId))
            throw new RuntimeException("The user already liked this project");

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        AppUser user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Like like = new Like();
        like.setUser(user);
        like.setProject(project);

        likeRepository.save(like);
    }

    public void unlikeArt(Long userId, Long artId) {
        likeRepository.deleteByUserIdAndArtId(userId, artId);
    }

    public void unlikeProject(Long userId, Long projectId) {
        likeRepository.deleteByUserIdAndProjectId(userId, projectId);
    }

    public long countLikesForArt(Long artId) {
        return likeRepository.countByArtId(artId);
    }

    public long countLikesForProject(Long projectId) {
        return likeRepository.countByProjectId(projectId);
    }
}
