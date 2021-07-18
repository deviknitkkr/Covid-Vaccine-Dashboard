package com.covid.module_helpdesk.controller;

import com.covid.module_helpdesk.entity.Issue;
import com.covid.module_helpdesk.service.IIssueService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {

    @Autowired
    IIssueService issueService;

    @PostMapping("/add")
    public Issue add(@RequestBody Issue issue) {
        return issueService.save(issue);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIssue(@PathVariable("id") Integer id) {
        return issueService.deleteById(id);
    }

    @GetMapping("/view")
    public List<Issue> getIssues(@And({
            @Spec(path = "date", params = "raisedAfter", spec = GreaterThanOrEqual.class),
            @Spec(path = "date", params = "raisedBefore", spec = LessThanOrEqual.class),
            @Spec(path = "zone", params = "zone", spec = Equal.class)
    }) Specification<Issue> spec) {
        return issueService.findBySpec(spec);

    }

    @GetMapping("/view/{id}")
    public Issue view(@PathVariable("id") Integer id) {
        return issueService.findById(id);
    }

}
