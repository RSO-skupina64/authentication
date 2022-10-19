package com.rso.microservice.api.model;

import java.time.LocalDateTime;

public class ErrorModel {

    private Integer statusCode;
    private String message;
    private LocalDateTime timestamp;

    public ErrorModel(Integer statusCode, String message, LocalDateTime timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
