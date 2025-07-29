package com.example.sagaribackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private String githubUrl;
    private String webUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectImage> images;

    @ManyToMany
    @JoinTable(
            name = "project_technology",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Like> likes;
}