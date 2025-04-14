package com.example.backend.entity;

import lombok.Data;

import java.util.List;

@Data
public class QuizSubmissionRequest {
    private String userEmail;
    private List<AnswerSubmission> answers;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<AnswerSubmission> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerSubmission> answers) {
        this.answers = answers;
    }
}

