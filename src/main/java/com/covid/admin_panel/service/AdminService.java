package com.covid.admin_panel.service;

import com.covid.admin_panel.entity.Admin;
import com.covid.admin_panel.entity.RegisterRequest;
import com.covid.admin_panel.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class AdminService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final Predicate<String> passwordValidator = s -> s.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$");
    private final Predicate<String> emailValidator = s -> s.matches("^[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-]+");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found !"));
    }

    @SneakyThrows
    public ResponseEntity<String> register(RegisterRequest registerRequest) {

        if (!emailValidator.test(registerRequest.getEmail()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Enter a valid email");

        else if (!passwordValidator.test(registerRequest.getPassword()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Password must contains atleat one Capital letter, one small letter, one digit and one special character...");

        else if (adminRepository.findUserByEmail(registerRequest.getEmail()).isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exist");

        else {
            Admin admin = new Admin();
            admin.setName(registerRequest.getName());
            admin.setEmail(registerRequest.getEmail());
            admin.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            return ResponseEntity.ok(adminRepository.save(admin).toString());
        }

    }


}
