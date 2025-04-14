package com.example.backend.controller;

import com.example.backend.entity.CourseProgress;
import com.example.backend.entity.courses;
import com.example.backend.entity.users;

import com.example.backend.repo.coursesRepo;
import com.example.backend.repo.userRepo;
import com.example.backend.service.CourseProgressService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/progress")

public class CourseProgressController {

    private final CourseProgressService progressService;
    private final userRepo userRepository;
    private final coursesRepo courseRepository;

    public CourseProgressController(CourseProgressService progressService, userRepo userRepository, coursesRepo courseRepository) {
        this.progressService = progressService;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateProgress(@RequestParam String email,
                                            @RequestParam Long courseId,
                                            @RequestParam double progress) {

        users user = userRepository.findByEmail(email);
        Optional<courses> courseOpt = courseRepository.findById(courseId);

        if (user == null || courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User or Course not found");
        }

        CourseProgress updated = progressService.updateProgress(user, courseOpt.get(), progress);
        return ResponseEntity.ok(updated);
    }

    @GetMapping
    public ResponseEntity<?> getProgress(@RequestParam String email,
                                         @RequestParam Long courseId) {

        users user = userRepository.findByEmail(email);
        Optional<courses> courseOpt = courseRepository.findById(courseId);

        if (user == null || courseOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User or Course not found");
        }

        return ResponseEntity.ok(progressService.getProgress(user, courseOpt.get()));
    }
}
