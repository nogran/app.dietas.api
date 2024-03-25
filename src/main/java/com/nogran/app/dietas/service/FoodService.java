package com.nogran.app.dietas.service;

import com.nogran.app.dietas.model.Food;
import java.util.List;

public interface FoodService {

    List<Food> findAll();

    List<Food> findByNameStartsWithIgnoreCase(String name);

    Food create(Food food);

    void delete(String name);
}
