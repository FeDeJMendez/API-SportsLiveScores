package com.utn.LabV2022.controller.advice;

import com.utn.LabV2022.exceptions.ErrorBody;
import com.utn.LabV2022.exceptions.NotLiveMatchesException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BasketballLiveMatchesControllerAdvice {

    @ExceptionHandler(value = {NotLiveMatchesException.class})
    protected ResponseEntity<Object> liveMatchesNoContent () {
        String message = "No hay partidos en vivo";
        return new ResponseEntity(ErrorBody.builder()
                .message(message)
                .build()
                /*message*/, // Tambien puedo devolver solamente el mensaje como un String.
                HttpStatus.OK
        );
    }

}
