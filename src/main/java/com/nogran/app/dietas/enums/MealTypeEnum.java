package com.nogran.app.dietas.enums;

import com.nogran.app.dietas.exception.GoalNotFoundException;

public enum MealTypeEnum {
  CAFE_DA_MANHA("Cafe da Manha"),
  ALMOCO("Almoco"),
  LANCHE("Lanche"),
  JANTA("Janta");

  private final String type;

  MealTypeEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static MealTypeEnum getType(String type) {
    for (MealTypeEnum meal : MealTypeEnum.values()) {
      if (meal.getType().equalsIgnoreCase(type)) {
        return meal;
      }
    }
    throw new GoalNotFoundException(type);
  }
}
