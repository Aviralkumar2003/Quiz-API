package com.project.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.quizapp.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz,Integer>{

}
