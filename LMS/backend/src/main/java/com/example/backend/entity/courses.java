package com.example.backend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@AllArgsConstructor
public class courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public void setInstructorName(String instructorName) {
        InstructorName = instructorName;
    }

    public users getInstructor() {
        return instructor;
    }

    public void setInstructor(users instructor) {
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    private String description;
    private String InstructorName;


    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private users instructor; // Instructor who teaches the course
}
