package com.blueyonder.ecommerce.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<String> handlePasswordMismatchException() {
        return new ResponseEntity<>("Password does not match.", HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException() {
        return new ResponseEntity<>("User already exists.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<String> handleUserNameNotFoundException() {
        return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
    }

}
