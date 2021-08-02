package com.covid.module_FAQ.service;

import com.covid.module_FAQ.entity.FAQ;
import com.covid.module_FAQ.repository.FAQRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FAQService implements IFAQService {

    @Autowired
    FAQRepository faqRepository;

    @Override
    public FAQ save(FAQ faq) {
        return faqRepository.save(faq);
    }

    @Override
    public List<FAQ> getAll() {
        return faqRepository.findAll();
    }

    @Override
    public ResponseEntity<String> deleteById(String id) {
        try {
            faqRepository.deleteById(id);
            return ResponseEntity.ok("Successfully deleted FAQ with id:"+id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("FAQ with id " + id + " not found!!!");
        }
    }
}
