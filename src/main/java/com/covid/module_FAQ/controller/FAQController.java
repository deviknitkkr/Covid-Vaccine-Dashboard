package com.covid.module_FAQ.controller;

import com.covid.module_FAQ.entity.FAQ;
import com.covid.module_FAQ.service.IFAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/faq")
public class FAQController {

    @Autowired
    IFAQService faqService;

    @PostMapping("/add")
    public FAQ add(@RequestBody FAQ faq) {
        return this.faqService.save(faq);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") UUID id) {
        return faqService.deleteById(id);
    }

    @GetMapping("/view")
    public List<FAQ> getAllFaq() {
        return faqService.getAll();
    }

}
