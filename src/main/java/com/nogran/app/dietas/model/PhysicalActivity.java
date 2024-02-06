package com.nogran.app.dietas.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhysicalActivity {

  private Sport sport;
  private int duration;
  private float calories;
  private LocalDateTime createdAt;
}
