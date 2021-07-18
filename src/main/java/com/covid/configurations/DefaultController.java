package com.covid.configurations;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class DefaultController implements ErrorController {

    @GetMapping()
    public ResponseEntity<String> onError() {
        return ResponseEntity.badRequest()
                .body("Your browser didn't send the full request ...");
    }

}
