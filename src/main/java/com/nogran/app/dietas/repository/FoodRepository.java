package com.nogran.app.dietas.repository;

import com.nogran.app.dietas.model.Food;
import java.util.Optional;

import com.nogran.app.dietas.model.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
  Optional<FoodEntity> findByName(String name);
}
