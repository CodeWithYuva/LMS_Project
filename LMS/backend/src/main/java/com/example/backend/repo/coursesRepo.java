package com.example.backend.repo;


import com.example.backend.entity.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface coursesRepo extends JpaRepository<courses, Long> { }

