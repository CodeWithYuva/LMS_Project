package com.example.backend.repo;


import com.example.backend.entity.CourseProgress;
import com.example.backend.entity.courses;
import com.example.backend.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseProgressRepo extends JpaRepository<CourseProgress, Long> {
    Optional<CourseProgress> findByUserAndCourse(users user, courses course);
}

