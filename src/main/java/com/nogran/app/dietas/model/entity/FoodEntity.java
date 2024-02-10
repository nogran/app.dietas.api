package com.nogran.app.dietas.model.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "food")
@RequiredArgsConstructor
public class FoodEntity {

  @Id
  @SequenceGenerator(name = "food_seq", sequenceName = "food_seq", allocationSize = 1)
  @GeneratedValue(generator = "food_seq")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "grams")
  private float grams;

  @Column(name = "carbohydrate")
  private float carbohydrate;

  @Column(name = "protein")
  private float protein;

  @Column(name = "fat")
  private float fat;

  @Column(name = "total_calories")
  private float totalCalories;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "timestamp")
  private OffsetDateTime createdAt;
}
