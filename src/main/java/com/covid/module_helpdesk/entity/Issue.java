package com.covid.module_helpdesk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Issue {

    @Id
    private Integer id;
    private Long contactNo;
    private String zone;
    private LocalDate date;

    @Column(length = 2000)
    private String description;

}
