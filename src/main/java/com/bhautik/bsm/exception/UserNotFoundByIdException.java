package com.bhautik.bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserNotFoundByIdException extends RuntimeException {
    private final String message;
}
