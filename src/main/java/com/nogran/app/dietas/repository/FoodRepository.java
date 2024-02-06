package com.nogran.app.dietas.repository;

import com.nogran.app.dietas.model.Food;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
  Optional<Food> findByName(String name);
}
