package com.nogran.app.dietas.exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message) {
    super(String.format("BadResquest[400]: %s", message));
  }
}
