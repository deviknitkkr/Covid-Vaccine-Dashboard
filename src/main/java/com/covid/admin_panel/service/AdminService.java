package com.covid.admin_panel.service;

import com.covid.admin_panel.entity.Admin;
import com.covid.admin_panel.entity.RegisterRequest;
import com.covid.admin_panel.exceptions.InvalidInputException;
import com.covid.admin_panel.repository.AdminRepository;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Data
@Service
@AllArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Predicate<String> passwordValidator = s->s.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
    private final Predicate<String> emailValidator = s -> s.matches("^[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-]+");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found !"));
    }

    @SneakyThrows
    public ResponseEntity<String> register(RegisterRequest registerRequest) {

        if (!emailValidator.test(registerRequest.getEmail()))
            throw new InvalidInputException("Enter a valid email");

        else if (!passwordValidator.test(registerRequest.getPassword()))
            throw new InvalidInputException("Password must contains atleat one Capital letter, one small letter, one digit and one special character...");

        else if (adminRepository.findUserByEmail(registerRequest.getEmail()).isPresent())
            throw new InvalidInputException("Email already exists...");

        else {
            Admin admin = new Admin();
            admin.setName(registerRequest.getName());
            admin.setEmail(registerRequest.getEmail());
            admin.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            adminRepository.save(admin);
            return ResponseEntity.ok("New Admin created successfully");
        }

    }


}
