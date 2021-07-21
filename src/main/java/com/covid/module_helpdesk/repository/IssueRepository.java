package com.covid.module_helpdesk.repository;

import com.covid.module_helpdesk.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IssueRepository extends
        JpaRepository<Issue, UUID>,
        JpaSpecificationExecutor<Issue> {

}
