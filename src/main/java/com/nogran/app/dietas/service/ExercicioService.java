package com.nogran.app.dietas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExercicioService {

  public float calcularGastoCalorico(float met, float peso, int tempo) {
    return met * peso * tempo / 60;
  }
}
