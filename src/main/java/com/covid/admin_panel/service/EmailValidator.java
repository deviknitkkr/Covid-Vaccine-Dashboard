package com.covid.admin_panel.service;

import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class EmailValidator implements Predicate<String> {
    /**
     * Evaluates this predicate on the given argument.
     *
     * @param s the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    private static final String MAIL_PATTERN="^[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-]+";
    @Override
    public boolean test(String email) {
        return email.matches(MAIL_PATTERN);
    }
}
