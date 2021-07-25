package com.covid.admin_panel.service;

import com.covid.admin_panel.entity.Admin;
import com.covid.admin_panel.entity.RegisterRequest;
import com.covid.admin_panel.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService implements UserDetailsService {



    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return adminRepository.findUserByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Not found !"));
    }

    public Admin register(RegisterRequest registerRequest) {
        // TODO : implement this
        Admin admin=new Admin();
        admin.setName(registerRequest.getName());
        admin.setEmail(registerRequest.getEmail());
        admin.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        return adminRepository.save(admin);
    }
}
