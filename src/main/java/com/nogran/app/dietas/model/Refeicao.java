package com.nogran.app.dietas.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Refeicao {

  private String nome;
  private List<Alimento> alimentos;
  private double totalCalorias;
  private LocalDateTime dataCriacao;

}
