package com.nogran.app.dietas.service.impl;

import com.nogran.app.dietas.exception.FoodDuplicatedException;
import com.nogran.app.dietas.exception.FoodNotFoundException;
import com.nogran.app.dietas.mapper.FoodMapper;
import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.repository.FoodRepository;
import com.nogran.app.dietas.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository repository;
    private final FoodMapper mapper;

    @Override
    public List<Food> findAll() {
        return mapper.entityToModel(repository.findAll());
    }

    @Override
    public List<Food> findByNameStartsWithIgnoreCase(String name) {
        return mapper.entityToModel(repository.findByNameStartsWithIgnoreCase(name));
    }

    public Food create(Food food) {
        var optFood = repository.findByName(food.getName());
        if (optFood.isPresent()) {
            throw new FoodDuplicatedException(food.getName());
        }
        return mapper.entityToModel(repository.save(mapper.modelToEntity(food)));
    }

    @Override
    public void delete(String name) {
        var optFood = repository.findByName(name);
        if (optFood.isEmpty()) {
            throw new FoodNotFoundException(name);
        }
        repository.delete(optFood.get());
    }

    private float calculateCalories(float kcal, float quantidade) {
        return kcal * quantidade;
    }
}
