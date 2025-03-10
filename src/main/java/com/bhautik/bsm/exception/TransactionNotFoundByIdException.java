package com.bhautik.bsm.exception;

public class TransactionNotFoundByIdException extends RuntimeException {
  public TransactionNotFoundByIdException(String message) {
    super(message);
  }
}
