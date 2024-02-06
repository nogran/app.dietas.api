package com.nogran.app.dietas.exception;

public class GoalNotFoundException extends NotFoundException {
  public GoalNotFoundException(String tipo) {
    super(String.format("Objetivo não encontrado para o tipo: [%s]", tipo));
  }
}
