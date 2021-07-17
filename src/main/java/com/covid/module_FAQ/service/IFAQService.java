package com.covid.module_FAQ.service;

import com.covid.module_FAQ.entity.FrequentlyAskedQuestions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFAQService {
    FrequentlyAskedQuestions save(FrequentlyAskedQuestions faq);

    List<FrequentlyAskedQuestions> getAll();

    ResponseEntity deleteById(int id);
}
