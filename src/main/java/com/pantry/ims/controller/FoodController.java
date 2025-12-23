package com.pantry.ims.controller;

import com.pantry.ims.dto.FoodRequestDTO;
import com.pantry.ims.dto.FoodResponseDTO;
import com.pantry.ims.entity.FoodEntity;
import com.pantry.ims.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private ResourcePatternResolver resourcePatternResolver;

    @PostMapping("save")
    public ResponseEntity<String> saveFoodInfo(@RequestBody FoodRequestDTO requestDTO) {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(requestDTO.getName());
        foodEntity.setCategory(requestDTO.getCategory());
        foodEntity.setExpiry(requestDTO.getExpiry());
        foodEntity.setQuantity(requestDTO.getQuantity());
        foodEntity.setQuantityUnit(requestDTO.getQuantityUnit());

        foodRepository.save(foodEntity);

        return new ResponseEntity<>("Food information added successfully", HttpStatus.OK);
    }

    @GetMapping("info")
    public ResponseEntity<List<FoodResponseDTO>> infoList() {
        List<FoodEntity> foodEntityList = foodRepository.findAll();

        int[] arr = {1, 2, 3, 4};

        for (int a : arr) {
            int b = a * 2;
        }

        List<FoodResponseDTO> foodResponseDTOList = new ArrayList<>();

        for (FoodEntity a : foodEntityList) {
            FoodResponseDTO foodResponseDTO = new FoodResponseDTO();
            foodResponseDTO.setName(a.getName());
            foodResponseDTO.setId(a.getId());
            foodResponseDTO.setExpiry(a.getExpiry());

            foodResponseDTOList.add(foodResponseDTO);
        }

        String name = "Sid";
        name = "Harry";
        StringBuilder b = new StringBuilder(("Hi"));

        return new ResponseEntity<>(foodResponseDTOList, HttpStatus.OK);
    }
}
