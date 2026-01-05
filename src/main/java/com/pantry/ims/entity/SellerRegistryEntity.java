package com.pantry.ims.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "SellerRegistryTable")
public class SellerRegistryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer Id;

    @Column(name="FoodName")
    private String FoodName;

    @Column(name="SellerDetails")
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
