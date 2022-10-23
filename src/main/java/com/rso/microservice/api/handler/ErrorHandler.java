package com.rso.microservice.api.handler;

import com.rso.microservice.api.AuthenticationAPI;
import com.rso.microservice.api.dto.ErrorDto;
import com.rso.microservice.exceptions.PasswordsDontMatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice(basePackageClasses = AuthenticationAPI.class)
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PasswordsDontMatchException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handlePasswordsDontMatchException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new ErrorDto(100, ex.getMessage(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = ex.getBindingResult().getAllErrors().stream().map(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            return fieldName + ": " + message;
        }).reduce("", (s, s2) -> s + "; " + s2);

        String message = String.format("Not all request parameters satisfy the validation: %s", errorMessage);

        return new ResponseEntity<>(new ErrorDto(101, message, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
