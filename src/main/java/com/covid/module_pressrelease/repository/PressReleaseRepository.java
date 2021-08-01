package com.covid.module_pressrelease.repository;

import com.covid.module_pressrelease.entity.PressRelease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PressReleaseRepository extends
        JpaRepository<PressRelease, String>,
        JpaSpecificationExecutor<PressRelease> {

}
