package com.nogran.app.dietas.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Metabolism {

  private float basalMetabolicRate;
  private float metabolicRate;
  private LocalDateTime createdAt;
}
