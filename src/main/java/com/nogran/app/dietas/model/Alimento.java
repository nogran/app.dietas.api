package com.nogran.app.dietas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Alimento {

  private String nome;

  private float quantidade;

  private float carboidrato;

  private float proteina;

  private float gordura;

  private float totalCaloria;
}
