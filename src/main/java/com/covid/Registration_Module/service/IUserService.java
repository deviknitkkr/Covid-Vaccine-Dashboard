package com.covid.Registration_Module.service;

import com.covid.Registration_Module.entity.User;
import org.springframework.data.jpa.domain.Specification;

public interface IUserService {
    User save(User user);

    Integer getFilteredUserCount(Specification<User> spec);
}
