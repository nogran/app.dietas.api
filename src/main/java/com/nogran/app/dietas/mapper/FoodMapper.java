package com.nogran.app.dietas.mapper;

import com.nogran.app.dietas.dto.request.CreateFoodRequestDTO;
import com.nogran.app.dietas.dto.response.FoodResponseDTO;
import com.nogran.app.dietas.model.Food;
import com.nogran.app.dietas.model.entity.FoodEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food entityToModel(FoodEntity entity);

    List<Food> entityToModel(List<FoodEntity> entities);

    FoodEntity modelToEntity(Food food);

    FoodResponseDTO toResponse(Food food);

    List<FoodResponseDTO> toResponse(List<Food> foods);

    Food createRequestToDomain(CreateFoodRequestDTO requestDTO);

}
