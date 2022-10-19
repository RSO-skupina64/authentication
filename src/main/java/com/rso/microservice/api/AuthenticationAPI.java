package com.rso.microservice.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
@OpenAPIDefinition(info = @Info(title = "Authentication API",
        description = "This is API documentation for Authentication Microservice",
        version = "0.1"))
@Tag(name = "Authentication")
public class AuthenticationAPI {

    @PostMapping("/register")
    public ResponseEntity register() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

}
