package com.pantry.ims.controller;

import com.pantry.ims.dto.food.FoodRequestDTO;
import com.pantry.ims.dto.food.FoodResponseDTO;
import com.pantry.ims.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    //add 4 crud apis
    // info name, expiry, quantity, price
    // save, info, modify, delete

    @Autowired
    private FoodService foodService;

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String SaveInfo(@RequestBody FoodRequestDTO foodRequestDTO) {
        return foodService.registerFood(foodRequestDTO);
    }


    @GetMapping(value = "info")
    public List<FoodResponseDTO> DisplaySellerInfo() {
        return foodService.foodInfo();
    }
}
