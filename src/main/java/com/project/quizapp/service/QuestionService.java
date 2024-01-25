package com.project.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.quizapp.DAO.QuestionDAO;
import com.project.quizapp.model.Questions;

@Service 
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Questions>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions questions) {
        try{
            questionDAO.save(questions);
            return new ResponseEntity<>("Question added successfully",HttpStatus.CREATED);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);
    }

}
