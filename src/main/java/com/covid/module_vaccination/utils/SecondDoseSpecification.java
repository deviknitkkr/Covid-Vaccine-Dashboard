package com.covid.module_vaccination.utils;

import com.covid.module_registration.entity.User;
import net.kaczmarzyk.spring.data.jpa.domain.NotNull;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.Specification;

@Spec(path = "secondDoseDate", spec = NotNull.class, constVal = "true")
@Configuration
public interface SecondDoseSpecification extends Specification<User> {

}
