
package com.example.backend.service;

import com.example.backend.entity.Question;
import com.example.backend.entity.Quiz;
import com.example.backend.repo.QuestionRepo;
import com.example.backend.repo.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuizService {

    private final QuizRepo quizRepo;
    private final QuestionRepo questionRepo;

    public QuizService(QuizRepo quizRepo, QuestionRepo questionRepo) {
        this.quizRepo = quizRepo;
        this.questionRepo = questionRepo;
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    public Question addQuestionToQuiz(Long quizId, Question question) {
        Quiz quiz = quizRepo.findById(quizId).orElseThrow();
        question.setQuiz(quiz);
        return questionRepo.save(question);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepo.findAll();
    }

    public List<Question> getQuestionsForQuiz(Long quizId) {
        return questionRepo.findByQuizId(quizId);
    }

    public int submitQuiz(Long quizId, List<String> submittedAnswers) {
        List<Question> questions = questionRepo.findByQuizId(quizId);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            if (i < submittedAnswers.size() &&
                    questions.get(i).getCorrectAnswer().equalsIgnoreCase(submittedAnswers.get(i))) {
                score++;
            }
        }

        return score;
    }
}
