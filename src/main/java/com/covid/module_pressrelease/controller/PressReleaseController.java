package com.covid.module_pressrelease.controller;

import com.covid.module_pressrelease.entity.PressRelease;
import com.covid.module_pressrelease.service.IPressReleaseService;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/press-release")
public class PressReleaseController {

    final IPressReleaseService pressReleaseService;

    public PressReleaseController(IPressReleaseService pressReleaseService) {
        this.pressReleaseService = pressReleaseService;
    }

    @PostMapping("/add")
    public PressRelease add(@RequestBody PressRelease pressRelease) {
        return pressReleaseService.save(pressRelease);
    }

    @GetMapping("/view")
    public List<PressRelease> viewAll(
            @And({
                    @Spec(path = "releaseDate", params = "releasedAfter", spec = GreaterThanOrEqual.class),
                    @Spec(path = "releaseDate", params = "releasedBefore", spec = LessThanOrEqual.class)
            }) Specification<PressRelease> spec) {
        return pressReleaseService.findAll(spec);
    }
}
