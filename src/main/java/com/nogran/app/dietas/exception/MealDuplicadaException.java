package com.nogran.app.dietas.exception;

public class MealDuplicadaException extends BadRequestException {
  public MealDuplicadaException(String refeicao) {
    super(String.format("Refeicao duplicada: [%s]", refeicao));
  }
}
