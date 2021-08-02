package com.covid.module_registration.service;

import com.covid.module_registration.entity.User;
import com.covid.module_registration.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    UserRepository userRepository;

    @Override
    public ResponseEntity<String> save(User user) {

        if (user.getAadharNo().toString().length() != 12)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Enter a valid aadhar no...");
        else if (userRepository.findById(user.getAadharNo()).isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Already registered with aadhar no...");
        else {
            user.setRegistrationDate(LocalDate.now());
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body("Successfully registered.");
        }
    }

    @Override
    public long getFilteredUserCount(Specification<User> spec) {
        return userRepository.count(spec);
    }
}
