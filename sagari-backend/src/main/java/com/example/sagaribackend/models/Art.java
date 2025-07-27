package com.example.sagaribackend.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "arts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Art {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String instagramLink;

    private String imageName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "art", cascade = CascadeType.ALL)
    private List<Like> likes;
}
