package com.covid.module_helpdesk.service;

import com.covid.module_helpdesk.entity.Issue;
import com.covid.module_helpdesk.repository.IssueRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssueService implements IIssueService {

    final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issue save(Issue issue) {
        issue.setDate(LocalDate.now());
        return issueRepository.save(issue);
    }

    @Override
    public ResponseEntity<String> deleteById(Integer id) {
        try {
            issueRepository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Issue with id " + id + " not found");
        }

        return ResponseEntity.ok("Successfully deleted");
    }

    @Override
    public Issue findById(Integer id) {
        return issueRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Issue> findBySpec(Specification<Issue> spec) {
        return issueRepository.findAll(spec);
    }
}
