package com.example.backend.controller;


import com.example.backend.entity.courses;
import com.example.backend.entity.users;
import com.example.backend.repo.coursesRepo;
import com.example.backend.repo.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {

    @Autowired
    private userRepo userRepository;

    @Autowired
    private coursesRepo courseRepository;



    //STUDENT - Course enroll
    @PostMapping("/enroll/{studentEmail}/{courseId}")
    public String enroll(@PathVariable String studentEmail, @PathVariable Long courseId) {
        users student = userRepository.findByEmail(studentEmail);
        if (student == null || !student.getRole().equals("STUDENT")) {
            return "Only students can enroll";
        }

        courses course = courseRepository.findById(courseId).orElse(null);
        if (course == null) return "Course not found";

        student.getEnrolledCourses().add(course);
        userRepository.save(student);

        return "Enrolled successfully in: " + course.getTitle();
    }
    //STUDENT - view enrolled courses
    @GetMapping("/courses/{studentEmail}")
    public List<courses> getEnrolledCourses(@PathVariable String studentEmail) {
        users student = userRepository.findByEmail(studentEmail);
        if (student == null || !student.getRole().equals("STUDENT")) {
            return null;
        }
        return student.getEnrolledCourses();
    }
}

