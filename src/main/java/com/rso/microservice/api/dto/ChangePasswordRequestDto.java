package com.rso.microservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ChangePasswordRequestDto {

    @JsonProperty("new_password")
    @NotBlank(message = " is required.")
    @Min(7)
    @Max(20)
    private String newPassword;

    @JsonProperty("repeat_password")
    @NotBlank(message = " is required.")
    @Min(7)
    @Max(20)
    private String repeatPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
