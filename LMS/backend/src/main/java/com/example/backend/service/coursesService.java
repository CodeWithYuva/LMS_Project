package com.example.backend.service;

import com.example.backend.entity.courses;
import com.example.backend.repo.coursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class coursesService {
    @Autowired
    private coursesRepo courseRepository;

    public courses create(courses course) {
        return courseRepository.save(course);
    }

    public List<courses> getAll() {
        return courseRepository.findAll();
    }

    public courses getById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public courses update(Long id, courses updatedcourses) {
        courses course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setTitle(updatedcourses.getTitle());
            course.setDescription(updatedcourses.getDescription());
            course.setInstructorName(updatedcourses.getInstructorName());
            return courseRepository.save(course);
        }
        return null;
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}

