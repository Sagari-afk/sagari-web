package com.example.sagaribackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "technology")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String technologyName;

    @ManyToMany(mappedBy = "technologies")
    private List<Project> projects;
}
