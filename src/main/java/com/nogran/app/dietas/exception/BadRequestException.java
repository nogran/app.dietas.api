package com.nogran.app.dietas.exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String message, Exception e) {
    super("BadResquest[400]: " + message, e);
  }
}
