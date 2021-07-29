package com.covid.module_registration.service;

import com.covid.module_registration.entity.User;
import com.covid.module_registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    UserRepository userRepository;

    @Override
    public User save(User user) {

        if (user.getAadharNo().toString().length() != 12)
            throw new IllegalStateException("Enter a valid aadhar no...");
        else if (userRepository.findById(user.getAadharNo()).isPresent())
            throw new IllegalStateException("Already registered with aadhar no...");
        else {
            user.setRegistrationDate(LocalDate.now());
            return this.userRepository.save(user);
        }
    }

    @Override
    public long getFilteredUserCount(Specification<User> spec) {
        return userRepository.count(spec);
    }
}
