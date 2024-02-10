package com.nogran.app.dietas.mapstruct;

import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.model.entity.FoodEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FoodMapper {

  FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

  Food entityToModel(FoodEntity entity);

  List<Food> entityToModel(List<FoodEntity> entities);
}
