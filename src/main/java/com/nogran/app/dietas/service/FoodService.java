package com.nogran.app.dietas.service;

import com.nogran.app.dietas.exception.FoodNotFoundException;
import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.repository.FoodRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodService {

  private final FoodRepository repository;

  public Food save(String name) {
    var optFood = findByName(name);
    if (optFood.isEmpty()) {
      throw new FoodNotFoundException(name);
    }
    return repository.save(optFood.get());
  }

  public void remove(String name) {
    var optFood = findByName(name);
    if (optFood.isEmpty()) {
      throw new FoodNotFoundException(name);
    }
    repository.delete(optFood.get());
  }

  private float calculateCalories(float kcal, float quantidade) {
    return kcal * quantidade;
  }

  private Optional<Food> findByName(String name) {
    return repository.findByName(name);
  }
}
