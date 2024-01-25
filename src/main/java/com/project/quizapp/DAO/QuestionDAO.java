package com.project.quizapp.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.quizapp.model.Questions;

import java.util.List;


@Repository
public interface QuestionDAO extends JpaRepository<Questions,Integer>{
    List<Questions> findByCategory(String category);

    @Query(value="SELECT * FROM Questions q WHERE q.category = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery=true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);

}
