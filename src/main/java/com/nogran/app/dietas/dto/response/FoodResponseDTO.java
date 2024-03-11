package com.nogran.app.dietas.dto.response;

import lombok.Data;

@Data
public class FoodResponseDTO {
  private String name;

  private float grams;

  private float carbohydrate;

  private float protein;

  private float fat;

  private float totalCalories;
}
