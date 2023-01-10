package com.rso.microservice.api;

import com.rso.microservice.api.dto.*;
import com.rso.microservice.service.AuthenticationService;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authentication")
@OpenAPIDefinition(info = @Info(title = "Authentication API",
        description = "This is API documentation for Authentication Microservice",
        version = "0.1"))
@Tag(name = "Authentication")
public class AuthenticationAPI {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Register a new User",
            description = "Given an username and password, register a new user into the application")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "User successfully registered",
                    content = @Content(schema = @Schema(implementation = MessageDto.class))),
            @ApiResponse(responseCode = "400", description = "User already registered",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<MessageDto> register(@Valid @RequestBody RegistrationRequestDto registrationRequest) {
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
            @ApiResponse(responseCode = "400", description = "Bad request.",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "Invalid credentials",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.login(loginRequest));
    }

    @PostMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Logout current user",
            description = "Log out an user from the application")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Log out successful"),
            @ApiResponse(responseCode = "400", description = "Log out failed",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<?> logout(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwt) {
        // todo: add code here
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PostMapping(value = "/check-user-role", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Check user's role fits",
            description = "Check if user has role that is specified in the request")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User role matches requested",
                    content = @Content(schema = @Schema(implementation = MessageDto.class))),
            @ApiResponse(responseCode = "400", description = "User role doesn't match requested",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(schema = @Schema(implementation = ErrorDto.class)))
    })
    public ResponseEntity<MessageDto> checkUserRole(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwt, @Valid @RequestBody CheckUserRoleRequestDto checkUserRoleRequest) {
        // todo: add code here
        authenticationService.checkRole(checkUserRoleRequest.getRole(), jwt);
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

}
