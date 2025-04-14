package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private users student; // The student who is enrolling

    @ManyToOne
    @JoinColumn(name = "course_id")
    private courses course; // The course they are enrolling in
}
