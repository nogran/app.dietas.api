package com.nogran.app.dietas.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exercicio {

  private Esporte esporte;
  private int tempo;
  private float caloria;
  private LocalDateTime dataCriacao;
}
