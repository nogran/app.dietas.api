package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.mapstruct.FoodMapper;
import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.repository.FoodRepository;
import com.nogran.app.dietas.service.FoodService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

  private final FoodRepository repository;
  private final FoodMapper mapper;

  @Override
  public List<Food> findAll() {
    return mapper.entityToModel(repository.findAll());
  }

  //  public Food save(String name) {
  //    var optFood = findByName(name);
  //    if (optFood.isEmpty()) {
  //      throw new FoodNotFoundException(name);
  //    }
  //    return repository.save(optFood.get());
  //  }
  //
  //  public void remove(String name) {
  //    var optFood = findByName(name);
  //    if (optFood.isEmpty()) {
  //      throw new FoodNotFoundException(name);
  //    }
  //    repository.delete(optFood.get());
  //  }
  //
  //  private float calculateCalories(float kcal, float quantidade) {
  //    return kcal * quantidade;
  //  }
  //
  //  private Optional<Food> findByName(String name) {
  //    return repository.findByName(name);
  //  }
}
