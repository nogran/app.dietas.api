package com.nogran.app.dietas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Food {
  private Long id;

  private String name;

  private float grams;

  private float carbohydrate;

  private float protein;

  private float fat;

  private float totalCalories;
}
