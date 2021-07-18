package com.covid.module_pressrelease.service;

import com.covid.module_pressrelease.entity.PressRelease;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IPressReleaseService {

    PressRelease save(PressRelease pressRelease);
    List<PressRelease> findAll(Specification<PressRelease> spec);
}
