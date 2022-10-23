package com.rso.microservice.api;

import com.rso.microservice.api.dto.*;
import com.rso.microservice.util.ValidationUtil;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authentication")
@OpenAPIDefinition(info = @Info(title = "Authentication API",
        description = "This is API documentation for Authentication Microservice",
        version = "0.1"))
@Tag(name = "Authentication")
public class AuthenticationAPI {


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register a new User",
            description = "Given an username and password, register a new user into the application")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User successfully registered",
                    content = @Content(schema = @Schema(implementation = RegistrationResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "User already registered",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<RegistrationResponseDto> register(@Valid @RequestBody RegistrationRequestDto registrationRequest) {
        // todo: add code here
        ValidationUtil.checkPasswordMatch(registrationRequest.getPassword(), registrationRequest.getRepeatPassword());
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Login a User",
            description = "Given an username and password, log in an user into the application")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Log in successful",
                    content = @Content(schema = @Schema(implementation = LoginResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid credentials",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        // todo: add code here
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Logout current user",
            description = "Log out an user from the application")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Log out successful",
                    content = @Content(schema = @Schema(implementation = RegistrationResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Log out failed",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<LoginResponseDto> logout() {
        // todo: add code here
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PutMapping(value = "/change-password", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Change password of an user",
            description = "Change password of an user")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Password successfully changed",
                    content = @Content(schema = @Schema(implementation = RegistrationResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Log out failed",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<LoginResponseDto> changePassword() {
        // todo: add code here
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

}
