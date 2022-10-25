package com.rso.microservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class LoginRequestDto {

    @JsonProperty("username")
    @NotBlank(message = "is required.")
    @Min(5)
    @Max(20)
    private String username;

    @JsonProperty("password")
    @NotBlank(message = "is required.")
    @Min(7)
    @Max(20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
