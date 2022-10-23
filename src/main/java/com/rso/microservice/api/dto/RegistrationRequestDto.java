package com.rso.microservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegistrationRequestDto {

    @NotBlank(message = "is required.")
    @JsonProperty("username")
    private String username;
    @NotBlank(message = "is required.")
    @JsonProperty("password")
    private String password;
    @NotBlank(message = "is required.")
    @JsonProperty("repeat_password")
    private String repeatPassword;

    @NotBlank(message = "is required.")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "is required.")
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank(message = "is required.")
    @JsonProperty("email")
    @Email
    private String email;

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
