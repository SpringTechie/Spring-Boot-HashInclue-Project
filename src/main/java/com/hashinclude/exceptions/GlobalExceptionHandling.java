package com.hashinclude.exceptions;

import com.hashinclude.models.ErrorDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(exception = {UserNotFoundException.class})
    public ErrorDetails handleException(UserNotFoundException exception) {

            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setErrorMessage(exception.getMessage());
            errorDetails.setErrorCode(exception.getStatusCode());
            return errorDetails;

    }
    @ExceptionHandler(exception = {RuntimeException.class})
    public ErrorDetails unknownError(RuntimeException runtimeException) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage(runtimeException.getMessage());
        errorDetails.setErrorCode(500);
        return errorDetails;

    }

}
