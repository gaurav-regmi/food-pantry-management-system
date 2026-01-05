package com.pantry.ims.service;

import com.pantry.ims.dto.food.FoodRequestDTO;
import com.pantry.ims.dto.food.FoodResponseDTO;

import java.util.List;

public interface FoodService {
    String registerFood(FoodRequestDTO foodRequestDTO);

    List<FoodResponseDTO> foodInfo();
}
