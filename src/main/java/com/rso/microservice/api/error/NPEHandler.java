package com.rso.microservice.api.error;

import com.rso.microservice.api.HealthcheckAPI;
import com.rso.microservice.api.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice(basePackageClasses = HealthcheckAPI.class)
public class NPEHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(HttpServletRequest request, Throwable ex) {
        return new ResponseEntity<>(new ErrorModel(100, ex.getMessage(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
