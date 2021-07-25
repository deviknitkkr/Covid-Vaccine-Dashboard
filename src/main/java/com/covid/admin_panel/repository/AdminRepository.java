package com.covid.admin_panel.repository;

import com.covid.admin_panel.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Optional<Admin> findUserByEmail(String email);
}
