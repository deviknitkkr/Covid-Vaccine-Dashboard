package com.covid.module_pressrelease.service;

import com.covid.module_pressrelease.entity.PressRelease;
import com.covid.module_pressrelease.repository.PressReleaseRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PressReleaseService implements IPressReleaseService {

    final PressReleaseRepository pressReleaseRepository;

    public PressReleaseService(PressReleaseRepository pressReleaseRepository) {
        this.pressReleaseRepository = pressReleaseRepository;
    }

    @Override
    public PressRelease save(PressRelease pressRelease) {
        pressRelease.setReleaseDate(LocalDate.now());
        return pressReleaseRepository.save(pressRelease);
    }

    @Override
    public List<PressRelease> findAll(Specification<PressRelease> spec) {
        return pressReleaseRepository.findAll(spec);
    }
}
