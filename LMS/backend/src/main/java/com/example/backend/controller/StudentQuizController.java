package com.example.backend.controller;


import com.example.backend.entity.*;
import com.example.backend.repo.QuestionRepo;
import com.example.backend.repo.QuizRepo;
import com.example.backend.repo.ResultRepo;
import com.example.backend.repo.userRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentQuizController {

    private final QuizRepo quizRepository;
    private final QuestionRepo questionRepository;
    private final ResultRepo resultRepository;

    public StudentQuizController(QuizRepo quizRepository, QuestionRepo questionRepository, userRepo userRepository, ResultRepo resultRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.resultRepository = resultRepository;
    }
    // see available quizzes
    @GetMapping("/available-quizzes")
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }
    // search quizzes
    @GetMapping("/available-quiz/{quizId}")
    public List<Question> getQuizQuestions(@PathVariable Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
    //submit quizes
    @PostMapping("/submit/{quizId}")
    public ResponseEntity<?> submitQuiz(@PathVariable Long quizId, @RequestBody QuizSubmissionRequest submissionRequest) {
        List<Question> questions = questionRepository.findByQuizId(quizId);
        int score = 0;

        for (AnswerSubmission submitted : submissionRequest.getAnswers()) {
            Question question = questions.stream()
                    .filter(q -> q.getId().equals(submitted.getQuestionId()))
                    .findFirst()
                    .orElse(null);

            if (question != null && question.getCorrectAnswer().equalsIgnoreCase(submitted.getAnswer())) {
                score++;
            }
        }

        Result result = Result.builder()
                .quizId(quizId)
                .userEmail(submissionRequest.getUserEmail())
                .score(score)
                .totalQuestions(questions.size())
                .build();

        resultRepository.save(result);
        return ResponseEntity.ok("Quiz submitted successfully. Score: " + score);
    }
}

