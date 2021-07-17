package com.covid.Registration_Module.service;

import com.covid.Registration_Module.entity.User;
import com.covid.Registration_Module.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setRegistrationDate(LocalDate.now());
        return this.userRepository.save(user);
    }

    @Override
    public Integer getFilteredUserCount(Specification<User> spec) {
        return userRepository.findAll(spec).size();
    }
}
