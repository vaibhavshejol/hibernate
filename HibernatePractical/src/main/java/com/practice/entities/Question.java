package com.practice.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @Column(name = "question_id")
    private Long questionId;
    private String question;

    @OneToOne(mappedBy="question")
    @JsonManagedReference
    private Answer answer;
}
