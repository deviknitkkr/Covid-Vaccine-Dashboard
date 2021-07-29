package com.covid.module_registration.service;

import com.covid.module_registration.entity.User;
import org.springframework.data.jpa.domain.Specification;

public interface IUserService {
    User save(User user);

    long getFilteredUserCount(Specification<User> spec);
}
