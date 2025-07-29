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

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectTechnology> technologies;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Like> likes;

    public List<ProjectTechnology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<ProjectTechnology> technologies) {
        this.technologies = technologies;
    }
}