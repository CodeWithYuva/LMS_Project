package com.example.backend.entity;

import jakarta.persistence.*;

@Entity
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private users user;

    @ManyToOne
    private courses course;

    private double progressPercentage;

    // Default constructor
    public CourseProgress() {}

    // All-args constructor
    public CourseProgress(Long id, users user, courses course, double progressPercentage) {
        this.id = id;
        this.user = user;
        this.course = course;
        this.progressPercentage = progressPercentage;
    }

    // Getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public users getUser() { return user; }

    public void setUser(users user) { this.user = user; }

    public courses getCourse() { return course; }

    public void setCourse(courses course) { this.course = course; }

    public double getProgressPercentage() { return progressPercentage; }

    public void setProgressPercentage(double progressPercentage) { this.progressPercentage = progressPercentage; }

    // Manual Builder class
    public static class Builder {
        private Long id;
        private users user;
        private courses course;
        private double progressPercentage;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder user(users user) {
            this.user = user;
            return this;
        }

        public Builder course(courses course) {
            this.course = course;
            return this;
        }

        public Builder progressPercentage(double progressPercentage) {
            this.progressPercentage = progressPercentage;
            return this;
        }

        public CourseProgress build() {
            return new CourseProgress(id, user, course, progressPercentage);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
