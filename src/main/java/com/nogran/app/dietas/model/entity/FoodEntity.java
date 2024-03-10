package com.nogran.app.dietas.model.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

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

  @CreatedBy
  @Column(name = "created_by", nullable = false)
  private String createdBy;

  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "timestamp")
  private OffsetDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", columnDefinition = "timestamp")
  private OffsetDateTime updatedAt;
}
