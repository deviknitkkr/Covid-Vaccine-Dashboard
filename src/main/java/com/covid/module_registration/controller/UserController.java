package com.covid.module_registration.controller;

import com.covid.module_registration.entity.User;
import com.covid.module_registration.service.IUserService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return this.userService.save(user);
    }

    @GetMapping("/view")
    public Integer getFilteredUserCount(@And({
            @Spec(path = "gender", params = "gender", spec = Equal.class),
            @Spec(path = "state", params = "state", spec = Equal.class),
            @Spec(path = "registrationDate", params = "registeredAfter", spec = GreaterThanOrEqual.class),
            @Spec(path = "registrationDate", params = "registeredBefore", spec = LessThanOrEqual.class)}) Specification<User> spec) {

        return userService.getFilteredUserCount(spec);
    }


}