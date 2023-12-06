package com.nogran.app.dietas.exception;

public class ErroRefeicaoDuplicadaException extends BadRequestException {
  public ErroRefeicaoDuplicadaException(String refeicao, Exception e) {
    super("Refeicao duplicada: " + refeicao, e);
  }
}
