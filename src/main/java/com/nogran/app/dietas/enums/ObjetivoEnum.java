package com.nogran.app.dietas.enums;

import java.util.Arrays;

public enum ObjetivoEnum {
  HIPERTROFIA("Hipertrofia"),
  DEFINICAO("Definicao"),
  MANTER_PESO("Manter Peso");

  private final String tipo;

  ObjetivoEnum(String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void listarValores() {
    Arrays.stream(ObjetivoEnum.values()).toList().forEach(i -> System.out.println(i.getTipo()));
  }

  public static ObjetivoEnum getTipo(String tipo) {
    for (ObjetivoEnum objetivo : ObjetivoEnum.values()) {
      if (objetivo.getTipo().equalsIgnoreCase(tipo)) {
        return objetivo;
      }
    }
    throw new IllegalArgumentException("Objetivo não encontrado para o tipo: " + tipo);
  }
}
