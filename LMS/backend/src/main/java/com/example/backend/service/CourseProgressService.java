package com.example.backend.service;

import com.example.backend.entity.CourseProgress;
import com.example.backend.entity.courses;
import com.example.backend.entity.users;
import com.example.backend.repo.CourseProgressRepo;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CourseProgressService {

    private final CourseProgressRepo progressRepository;

    public CourseProgressService(CourseProgressRepo progressRepository) {
        this.progressRepository = progressRepository;
    }

    public CourseProgress updateProgress(users user, courses course, double progress) {
        Optional<CourseProgress> existing = progressRepository.findByUserAndCourse(user, course);

        CourseProgress cp = existing.orElse(
                CourseProgress.builder()
                        .user(user)
                        .course(course)
                        .build()
        );

        cp.setProgressPercentage(progress);
        return progressRepository.save(cp);
    }

    public Optional<CourseProgress> getProgress(users user, courses course) {
        return progressRepository.findByUserAndCourse(user, course);
    }
}
