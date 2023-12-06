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

  private float calcularCaloria() {
    var proteinaKcal = 4;
    var carboidratoKcal = 4;
    var gorduraKcal = 9;

    return this.carboidrato * carboidratoKcal
        + this.proteina * proteinaKcal
        + this.gordura * gorduraKcal;
  }
}
