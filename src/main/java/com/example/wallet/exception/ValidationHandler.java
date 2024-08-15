package com.example.wallet.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidationHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        var allErrors = e.getBindingResult().getAllErrors();
        allErrors.forEach(err -> {
            var fieldError = (FieldError)err;
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public Map<String, String> handleValidationErrors(HttpMessageNotReadableException e)  {
        Map<String, String> errors = new HashMap<>();
        errors.put("Reason", e.getLocalizedMessage());
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({WalletException.class, ConstraintViolationException.class})
    public Map<String, String> handleValidationErrors(RuntimeException e)  {
        Map<String, String> errors = new HashMap<>();
        errors.put("Reason", e.getLocalizedMessage());
        return errors;
    }

}
