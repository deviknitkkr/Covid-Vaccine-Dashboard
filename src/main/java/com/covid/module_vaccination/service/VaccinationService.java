package com.covid.module_vaccination.service;

import com.covid.module_registration.entity.User;
import com.covid.module_registration.repository.UserRepository;
import com.covid.module_vaccination.utils.FirstDoseSpecification;
import com.covid.module_vaccination.vo.VaccinationStatus;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.kaczmarzyk.spring.data.jpa.domain.NotNull;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class VaccinationService implements IVaccinationService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<String> applyFirstDose(Long aadhar_no) {

        Optional<User> user = userRepository.findById(aadhar_no);

        if (user.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not registered");

        else if (user.get().getFirstDoseDate() != null)
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("First dose is already applied");

        else
            user.get().setFirstDoseDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.OK).body("First Dose done");
    }

    @Override
    public ResponseEntity<String> applySecondDose(Long aadhar_no) {

        Optional<User> user = userRepository.findById(aadhar_no);

        if (user.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User is not registered");

        else if (user.get().getFirstDoseDate() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("First dose is pending.");

        else if (user.get().getSecondDoseDate() != null)
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Second dose is already applied");

        else
            user.get().setSecondDoseDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.OK).body("Second Dose done");
    }

    @Override
    public Long viewFirstDose(Specification<User> specification) {
//        specification.and(firstDoseSpecification);
        return userRepository.count(specification);
    }

    @Override
    public Long viewSecondDose(Specification<User> specification) {
        return userRepository.count(specification);
    }

    @Override
    public Long getTotalRegistered() {
        return userRepository.count();
    }

    @SneakyThrows
    @Override
    public VaccinationStatus getVaccinationStatus(Long aadhar_no) {

        VaccinationStatus vaccinationStatus = new VaccinationStatus();
        Optional<User> user = userRepository.findById(aadhar_no);

        if (user.isEmpty())
            throw new Exception("No user found with id:" + aadhar_no);
        else {
            vaccinationStatus.setRegistrationDate(user.get().getRegistrationDate());
            vaccinationStatus.setFirstDoseDate(user.get().getFirstDoseDate());
            vaccinationStatus.setSecondDoseDate(user.get().getSecondDoseDate());
        }

        return vaccinationStatus;
    }

}