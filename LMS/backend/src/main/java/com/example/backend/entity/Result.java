package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quizId;
    private String userEmail;
    private int score;
    private int totalQuestions;

    public Result() {}

    public Result(Long id, Long quizId, String userEmail, int score, int totalQuestions) {
        this.id = id;
        this.quizId = quizId;
        this.userEmail = userEmail;
        this.score = score;
        this.totalQuestions = totalQuestions;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    // Manual Builder class
    public static class ResultBuilder {
        private Long id;
        private Long quizId;
        private String userEmail;
        private int score;
        private int totalQuestions;

        public ResultBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ResultBuilder quizId(Long quizId) {
            this.quizId = quizId;
            return this;
        }

        public ResultBuilder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public ResultBuilder score(int score) {
            this.score = score;
            return this;
        }

        public ResultBuilder totalQuestions(int totalQuestions) {
            this.totalQuestions = totalQuestions;
            return this;
        }

        public Result build() {
            return new Result(id, quizId, userEmail, score, totalQuestions);
        }
    }

    public static ResultBuilder builder() {
        return new ResultBuilder();
    }
}
