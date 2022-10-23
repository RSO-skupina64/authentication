package com.rso.microservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationResponseDto {

    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
