package com.example.sagaribackend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "project_technologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technologyName;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
