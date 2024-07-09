package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}
