package com.covid.module_vaccination.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationStatus {

    private LocalDate registrationDate;
    private LocalDate firstDoseDate;
    private LocalDate secondDoseDate;

}
