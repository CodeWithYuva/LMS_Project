package com.example.backend.repo;

import com.example.backend.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result, Long> {
    List<Result> findByUserEmail(String email);
}





