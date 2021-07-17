package com.covid.module_FAQ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FrequentlyAskedQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String question;

    @Column(length = 2000)
    private String answer;

}
