package com.maxi.gestaoServico.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> noSuchElementException(NoSuchElementException e) {
        StandardError error = new StandardError(System.currentTimeMillis(), e.getMessage(),
                HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    /*
     * @ExceptionHandler(MethodArgumentTypeMismatchException.class)
     * public ResponseEntity<StandardError>
     * methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
     * StandardError err = new StandardError(System.currentTimeMillis(),
     * "O URL informado não é permitodo no sistema",
     * HttpStatus.BAD_REQUEST.value());
     * return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
     * }
     */

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> methodArgumentMistmatchException(MethodArgumentTypeMismatchException e) {
        StandardError err = new StandardError(System.currentTimeMillis(),
                "O ID informado na URL não pode conter que número",
                HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardError> constraintViolationException(ConstraintViolationException e) {
        StandardError err = new StandardError(System.currentTimeMillis(), e.getMessage(),
                HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
