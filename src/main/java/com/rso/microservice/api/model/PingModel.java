package com.rso.microservice.api.model;

public class PingModel {

    private String response;

    public PingModel(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
