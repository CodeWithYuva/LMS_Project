package com.example.backend.repo;

import com.example.backend.entity.Enrollment;
import com.example.backend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> { }

