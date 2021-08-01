package com.covid.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController implements ErrorController {

    @Value("${spring.welcome.message}")
    String welcome_message;

    @GetMapping("/error")
    public ResponseEntity<String> onError() {
        return ResponseEntity.badRequest()
                .body("Your browser didn't send the full request ...");
    }

    @GetMapping("/home")
    public String home() {
        return welcome_message;
    }
}
