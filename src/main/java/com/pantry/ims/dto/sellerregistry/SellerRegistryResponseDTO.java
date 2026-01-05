package com.pantry.ims.dto.sellerregistry;

public class SellerRegistryResponseDTO {
    private Integer Id;
    private String FoodName;
    private String SellerDetails;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getSellerDetails() {
        return SellerDetails;
    }

    public void setSellerDetails(String sellerDetails) {
        SellerDetails = sellerDetails;
    }
}
