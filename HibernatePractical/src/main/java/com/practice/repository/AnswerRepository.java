package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    
}
