package com.pantry.ims.dto.food;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequestDTO {
    private String name;
    private String quantity;
    private String price;
    private Integer sellerId;
}
