package com.nogran.app.dietas.model;

import lombok.Data;

@Data
public class Food {

    private String name;

    private String company;

    private float grams;

    private float carbohydrate;

    private float protein;

    private float fat;

    private float totalCalories;
}
