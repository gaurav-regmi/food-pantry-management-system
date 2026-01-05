package com.pantry.ims.dto.food;

import com.pantry.ims.dto.seller.SellerResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodResponseDTO {
    private String name;
    private String price;
    private String quantity;
    private SellerResponseDTO sellerResponseDTO;
}
