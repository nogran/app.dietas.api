package com.nogran.app.dietas.exception;

public class FoodDuplicatedException extends BadRequestException {
  public FoodDuplicatedException(String name) {
    super(String.format("Food already exists: [%s]", name));
  }
}
