package com.covid.admin_panel.service;

import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class PasswordValidator implements Predicate<String> {
    /**
     * Evaluates this predicate on the given argument.
     *
     * @param s the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";

    @Override
    public boolean test(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}
