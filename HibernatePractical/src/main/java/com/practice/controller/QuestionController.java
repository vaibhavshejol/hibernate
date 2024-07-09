package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.Question;
import com.practice.repository.QuestionRepository;

import java.util.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository){
        this.questionRepository=questionRepository;
    }
    
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
        Question createdQuestion = questionRepository.save(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestion);
    }

    @GetMapping
    public ResponseEntity<List<Question>> getAllQuestion(){
        return (ResponseEntity<List<Question>>) questionRepository.findAll();
    }
    
    // @GetMapping("/{id}")
    // public ResponseEntity<Question> getQuestionById(Long id, Question question){

    // }
    
    // @PutMapping("/{id}")
    // public ResponseEntity<Question> updateByIdQuestion(Long id, Question question){

    // }
    
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Question> deleteByIdQuestion(Long id){

    // }
}
