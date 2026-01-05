package com.pantry.ims.service.impl;

import com.pantry.ims.dto.food.FoodRequestDTO;
import com.pantry.ims.dto.food.FoodResponseDTO;
import com.pantry.ims.dto.seller.SellerResponseDTO;
import com.pantry.ims.entity.FoodEntity;
import com.pantry.ims.entity.SellerEntity;
import com.pantry.ims.repository.FoodRepository;
import com.pantry.ims.repository.SellerRepository;
import com.pantry.ims.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public String registerFood(FoodRequestDTO foodRequestDTO) {

        Optional<SellerEntity> optionalSeller = sellerRepository.findById(foodRequestDTO.getSellerId());

        if (optionalSeller.isEmpty()) {
            return "Invalid seller information";
        }

        SellerEntity sellerEntity = optionalSeller.get();

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(foodRequestDTO.getName());
        foodEntity.setPrice(foodRequestDTO.getPrice());
        foodEntity.setQuantity(foodRequestDTO.getQuantity());
        foodEntity.setSellerEntity(sellerEntity);

        foodRepository.save(foodEntity);

        return "Successfully registered food details";
    }

    @Override
    public List<FoodResponseDTO> foodInfo() {
        List<FoodEntity> foodEntityList = foodRepository.findAll();

        List<FoodResponseDTO> foodResponseDTOList = new ArrayList<>();

        for (FoodEntity foodEntity : foodEntityList) {
            SellerResponseDTO sellerResponseDTO = new SellerResponseDTO();
            sellerResponseDTO.setName(foodEntity.getSellerEntity().getName());
            sellerResponseDTO.setAddress(foodEntity.getSellerEntity().getAddress());
            sellerResponseDTO.setId(foodEntity.getSellerEntity().getId());

            FoodResponseDTO foodResponseDTO = new FoodResponseDTO();
            foodResponseDTO.setName(foodEntity.getName());
            foodResponseDTO.setPrice(foodEntity.getPrice());
            foodResponseDTO.setQuantity(foodEntity.getQuantity());
            foodResponseDTO.setSellerResponseDTO(sellerResponseDTO);

            foodResponseDTOList.add(foodResponseDTO);
        }

        return foodResponseDTOList;
    }
}
