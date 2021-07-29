package com.covid.module_vaccination.utils;

import com.covid.module_registration.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Component
public class FirstDoseSpecification implements Specification<User> {

    @Bean
    FirstDoseSpecification getFirstDoseSpecification(){
        return new FirstDoseSpecification();
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.isNotEmpty(root.get("firstDoseDate"));
    }
}
