package com.bhautik.bsm.exceptionhandler;

import com.bhautik.bsm.exception.UserNotFoundByIdException;
import com.bhautik.bsm.util.ErrorStructure;
import com.bhautik.bsm.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {

    private final RestResponseBuilder responseBuilder;

    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByIdException ex){
        return responseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "User not found by given Id");
    }
}
