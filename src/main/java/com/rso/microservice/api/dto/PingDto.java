package com.rso.microservice.api.dto;

public class PingDto {

    private String response;

    public PingDto(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
