package com.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.Answer;
import com.practice.entities.Question;
import com.practice.repository.AnswerRepository;
import com.practice.repository.QuestionRepository;

import java.util.*;


@RestController
@RequestMapping("/answer")
public class AnswerController {
    
    private AnswerRepository answerRepository;

    public AnswerController(AnswerRepository answerRepository){
        this.answerRepository=answerRepository;
    }
    
    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        Answer createdAnswer = answerRepository.save(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnswer);
    }

    @GetMapping
    public ResponseEntity<List<Answer>> getAllAnswer(){
        return (ResponseEntity<List<Answer>>) answerRepository.findAll();
    }
}
