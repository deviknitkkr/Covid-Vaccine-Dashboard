package com.covid.module_FAQ.service;

import com.covid.module_FAQ.entity.FAQ;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFAQService {
    FAQ save(FAQ faq);

    List<FAQ> getAll();

    ResponseEntity<String> deleteById(String id);
}
