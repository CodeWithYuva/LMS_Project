package com.example.backend.controller;

import com.example.backend.entity.Question;
import com.example.backend.entity.Quiz;
import com.example.backend.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping

public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // ADMIN - Create Quiz
    @PostMapping("admin/quizzes")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        return ResponseEntity.ok(quizService.createQuiz(quiz));
    }

    // ADMIN - Add Question
    @PostMapping("/admin/quizzes/{quizId}/questions")
    public ResponseEntity<Question> addQuestion(@PathVariable Long quizId, @RequestBody Question question) {
        return ResponseEntity.ok(quizService.addQuestionToQuiz(quizId, question));
    }

    // STUDENT - Get Quizzes
    @GetMapping("/student/quizzes")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.getAllQuizzes());
    }

    // STUDENT - Get Questions
    @GetMapping("/student/quizzes/{quizId}")
    public ResponseEntity<List<Question>> getQuestions(@PathVariable Long quizId) {
        return ResponseEntity.ok(quizService.getQuestionsForQuiz(quizId));
    }

    // STUDENT - Submit Quiz
    @PostMapping("/student/quizzes/{quizId}/submit")
    public ResponseEntity<String> submitQuiz(@PathVariable Long quizId, @RequestBody List<String> answers) {
        int score = quizService.submitQuiz(quizId, answers);
        return ResponseEntity.ok("Score: " + score + "/" + answers.size());
    }
}
