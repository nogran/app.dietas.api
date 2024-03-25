package com.nogran.app.dietas.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateFoodRequestDTO {

  @NotNull
  private String name;

  private String company;

  @NotNull
  private float grams;

  @NotNull
  private float carbohydrate;

  @NotNull
  private float protein;

  @NotNull
  private float fat;

  @NotNull
  private float totalCalories;
}
