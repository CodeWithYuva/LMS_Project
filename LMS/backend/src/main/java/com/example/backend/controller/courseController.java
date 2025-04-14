package com.example.backend.controller;

import com.example.backend.entity.courses;
import com.example.backend.service.coursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/courses")
public class courseController {

    @Autowired
    private coursesService courseService;

    @PostMapping
    public courses createcourses(@RequestBody courses course) {
        return courseService.create(course);
    }

    @GetMapping
    public List<courses> getAllcoursess() {
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public courses getcoursesById(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public courses updatecourses(@PathVariable Long id, @RequestBody courses updatedcourses) {
        return courseService.update(id, updatedcourses);
    }

    @DeleteMapping("/{id}")
    public void deletecourses(@PathVariable Long id) {
        courseService.delete(id);
    }
}

