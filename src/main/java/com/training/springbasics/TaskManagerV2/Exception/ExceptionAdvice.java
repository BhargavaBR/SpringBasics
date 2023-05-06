package com.training.springbasics.TaskManagerV2.Exception;

import com.training.springbasics.TaskManager.Exception.IvalidRequestException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({
            IvalidRequestException.class,
            IllegalArgumentException.class,
            RuntimeException.class
    })
    public ExceptionResponseDTO handleInvalidRequestException(Exception ex) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO();
        exceptionResponseDTO.setStatus(400);
        if(ex instanceof  IllegalArgumentException){
            exceptionResponseDTO.setError("The Entered Data is not a valid");
        }
        else if(ex instanceof  RuntimeException){
            exceptionResponseDTO.setError("Something Went Wrong");
        }
        else if(ex instanceof IvalidRequestException){
            exceptionResponseDTO.setError("The Data is Incorrect");
        }
        else exceptionResponseDTO.setError("IDK, Some thing is not correct");
        return exceptionResponseDTO;
    }

}
