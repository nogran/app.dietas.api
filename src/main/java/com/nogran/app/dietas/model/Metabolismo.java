package com.nogran.app.dietas.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Metabolismo {

  private float taxaMetabolicaBasal;
  private float consumoMetabolico;
  private LocalDateTime dataCriacao;
}
