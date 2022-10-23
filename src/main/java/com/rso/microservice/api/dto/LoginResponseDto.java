package com.rso.microservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseDto {

    @JsonProperty("jwt")
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
