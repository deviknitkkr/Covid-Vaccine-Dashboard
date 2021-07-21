package com.covid.module_registration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @Column(name = "id")
    private Long aadharNo;
    private String name;
    private String gender;
    private String state;
    private LocalDate registrationDate;
    private LocalDate firstDoseDate;
    private LocalDate secondDoseDate;

}
