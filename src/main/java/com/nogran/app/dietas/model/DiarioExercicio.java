package com.nogran.app.dietas.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DiarioExercicio {
  private List<Exercicio> exercicios;
  private LocalDate data;
  private int totalMinutos;
  private double totalCalorias;
}
