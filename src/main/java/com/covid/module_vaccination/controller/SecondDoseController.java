package com.covid.module_vaccination.controller;

import com.covid.module_registration.entity.User;
import com.covid.module_vaccination.service.IVaccinationService;
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
@RequestMapping("/vaccination/second-dose")
public class SecondDoseController {

    @Autowired
    IVaccinationService vaccinationService;


    @PostMapping("/add/{id}")
    public ResponseEntity<String> applySecondDose(@PathVariable("id") Long aadhar_no) {
        return vaccinationService.applySecondDose(aadhar_no);
    }

    @GetMapping("/view")
    public Long viewSecondDose(
            @And({
                    @Spec(path = "gender", params = "gender", spec = Equal.class),
                    @Spec(path = "state", params = "state", spec = Equal.class),
                    @Spec(path = "second_dose_date", params = "vaccinatedAfter", spec = GreaterThanOrEqual.class),
                    @Spec(path = "second_dose_date", params = "vaccinatedBefore", spec = LessThanOrEqual.class)
            })
                    Specification<User> specification
    ) {
        return vaccinationService.viewSecondDose(specification);
    }

    @GetMapping("/view/persent")
    public String viewSecondDosePersent(){

        Long vaccinated=this.viewSecondDose(null);
        Long registered=vaccinationService.getTotalRegistered();

        return (vaccinated*100/registered)+"%";
    }
}
