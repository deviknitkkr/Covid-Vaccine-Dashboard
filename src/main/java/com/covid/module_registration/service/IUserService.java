package com.covid.module_registration.service;

import com.covid.module_registration.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<String> save(User user);

    long getFilteredUserCount(Specification<User> spec);
}
