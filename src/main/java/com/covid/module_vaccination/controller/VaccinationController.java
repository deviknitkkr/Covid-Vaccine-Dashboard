package com.covid.module_vaccination.controller;

import com.covid.module_vaccination.service.IVaccinationService;
import com.covid.module_vaccination.vo.VaccinationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    IVaccinationService vaccinationService;

    @GetMapping("view/{id}")
    public VaccinationStatus getVaccinationStatus(@PathVariable("id") Long aadhar_no){
        return vaccinationService.getVaccinationStatus(aadhar_no);
    }
}
