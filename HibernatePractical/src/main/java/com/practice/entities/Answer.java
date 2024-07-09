package com.practice.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Answer {
    @Id
    @Column(name = "answer_id")
    private Long answerId;
    private String answer;
    
    @OneToOne
    @JsonBackReference
    private Question question;
}
