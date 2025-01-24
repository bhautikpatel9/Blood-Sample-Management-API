package com.bhautik.bsm.exception;

import com.bhautik.bsm.util.ErrorStructure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class FiledErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ObjectError> objectsErrors =ex.getAllErrors();
        List<FiledErrorStructure> errors = new ArrayList<>();

        for(ObjectError objectError : objectsErrors){
            FieldError error = (FieldError) objectError;

            errors.add(FiledErrorStructure.builder()
                    .filed(error.getField())
                    .message(error.getDefaultMessage())
                    .rejectedValue(error.getRejectedValue())
                    .build());
        }

        ErrorStructure<List<FiledErrorStructure>> error = new ErrorStructure<>();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Failed to User ");
        error.setRootCause(errors);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FiledErrorStructure{
        private String filed;
        private Object rejectedValue;
        private String message;
    }
}
