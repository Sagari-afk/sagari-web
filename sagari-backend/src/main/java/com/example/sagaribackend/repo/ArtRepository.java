package com.example.sagaribackend.repo;

import com.example.sagaribackend.models.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends JpaRepository<Art, Long> {
}

