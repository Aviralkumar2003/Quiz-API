package com.project.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizapp.DAO.QuestionDAO;
import com.project.quizapp.DAO.QuizDAO;
import com.project.quizapp.model.Questions;
import com.project.quizapp.model.QuestionsWrapper;
import com.project.quizapp.model.Quiz;
import com.project.quizapp.model.Response;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Questions> questions = questionDAO.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionsWrapper>> GetQuiz(Integer id) {
        Optional<Quiz> quiz=quizDAO.findById(id);
        List<Questions> questionfromDB=quiz.get().getQuestions();
        List<QuestionsWrapper> questionsForQuiz=new ArrayList<>();
        for(Questions q:questionfromDB) {
            QuestionsWrapper qw=new QuestionsWrapper(q.getQid(), q.getQuestion_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForQuiz.add(qw);
        }
        return new ResponseEntity<>(questionsForQuiz,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizDAO.findById(id).get();
        List<Questions> questions=quiz.getQuestions();
        int correct=0;
        int i=0;
        for(Response response:responses) {
            if(response.getResponse().equals(questions.get(i).getRight_answer())) {
                correct++;
                i++;
            }
        }
        return new ResponseEntity<>(correct,HttpStatus.OK);
    }
}
