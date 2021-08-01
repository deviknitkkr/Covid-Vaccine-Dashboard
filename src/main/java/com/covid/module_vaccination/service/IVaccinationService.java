package com.covid.module_vaccination.service;

import com.covid.module_registration.entity.User;
import com.covid.module_vaccination.vo.VaccinationStatus;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

public interface IVaccinationService {

    ResponseEntity<String> applyFirstDose(Long aadhar_no);

    ResponseEntity<String> applySecondDose(Long aadhar_no);

    Long viewFirstDose(Specification<User> specification);

    Long viewSecondDose(Specification<User> specification);

    Long getTotalRegistered();

    VaccinationStatus getVaccinationStatus(Long aadhar_no);

}
