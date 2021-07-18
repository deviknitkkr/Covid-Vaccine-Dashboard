package com.covid.module_helpdesk.service;

import com.covid.module_helpdesk.entity.Issue;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IIssueService {

    Issue save(Issue issue);
    ResponseEntity<String> deleteById(Integer id);
    Issue findById(Integer id);
    List<Issue> findBySpec(Specification<Issue> spec);
}
