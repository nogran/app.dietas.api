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
public class User {

  private String name;
  private String email;
  private String password;
  private LocalDate birthDate;
  private float weight;
  private int height;
  private String gender;
  private String goal;
  private List<Meal> meals;
  private Metabolism metabolism;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
