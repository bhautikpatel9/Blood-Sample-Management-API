package com.bhautik.bsm.exception;

public class AddressNotFoundByIdException extends RuntimeException {
    public AddressNotFoundByIdException(String message) {
        super(message);
    }
}
