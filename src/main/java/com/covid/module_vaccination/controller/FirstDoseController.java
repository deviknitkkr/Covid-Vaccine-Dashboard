package com.covid.module_vaccination.controller;

import com.covid.module_registration.entity.User;
import com.covid.module_vaccination.service.IVaccinationService;
import com.covid.module_vaccination.utils.FirstDoseSpecification;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccination/first-dose")
public class FirstDoseController {

    @Autowired
    IVaccinationService vaccinationService;

    @PostMapping("/add/{id}")
    public ResponseEntity<String> applyFirstDose(@PathVariable("id") Long aadhar_no) {
        return vaccinationService.applyFirstDose(aadhar_no);
    }


    @GetMapping("/view")
    public Long viewFirstDose(
            @And({
                    @Spec(path = "gender", params = "gender", spec = Equal.class),
                    @Spec(path = "state", params = "state", spec = Equal.class),
                    @Spec(path = "firstDoseDate", params = "vaccinatedAfter", spec = GreaterThanOrEqual.class),
                    @Spec(path = "secondDoseDate", params = "vaccinatedBefore", spec = LessThanOrEqual.class)
            }) Specification<User> specification, FirstDoseSpecification firstDoseSpecification) {

        return vaccinationService.viewDoseCount(Specification.where(firstDoseSpecification).and(specification));
    }

    @GetMapping("/view/percent")
    public String viewFirstDosePercent(FirstDoseSpecification firstDoseSpecification) {

        Long vaccinated = this.viewFirstDose(null, firstDoseSpecification);
        Long registered = vaccinationService.getTotalRegistered();

        return (vaccinated * 100 / registered) + "%";
    }

}
