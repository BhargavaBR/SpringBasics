package com.training.springbasics.TaskManager.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class IvalidRequestException extends RuntimeException {
    public IvalidRequestException(String message) {
        super(message);
    }
}
