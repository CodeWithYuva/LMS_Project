package com.example.backend.repo;

import com.example.backend.entity.progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface progressRepo extends JpaRepository<progress,Long> {
}

