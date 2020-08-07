package com.forogh.opinionPoll.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
public class ServiceUnAvailabeException extends RuntimeException {
    public ServiceUnAvailabeException(String message) {
        super(message);
    }
}