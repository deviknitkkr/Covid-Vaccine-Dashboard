package com.covid.module_FAQ.service;

import com.covid.module_FAQ.entity.FrequentlyAskedQuestions;
import com.covid.module_FAQ.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQService implements IFAQService{

    @Autowired
    FAQRepository faqRepository;

    @Override
    public FrequentlyAskedQuestions save(FrequentlyAskedQuestions faq) {
        return faqRepository.save(faq);
    }

    @Override
    public List<FrequentlyAskedQuestions> getAll() {
        return faqRepository.findAll();
    }

    @Override
    public ResponseEntity deleteById(int id) {
        try {
            faqRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
