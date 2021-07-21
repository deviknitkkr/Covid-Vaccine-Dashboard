package com.covid.module_helpdesk.service;

import com.covid.module_helpdesk.entity.Issue;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IIssueService {

    Issue save(Issue issue);
    ResponseEntity<String> deleteById(UUID id);
    Issue findById(UUID id);
    List<Issue> findBySpec(Specification<Issue> spec);
}
