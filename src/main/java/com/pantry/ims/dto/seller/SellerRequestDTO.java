package com.pantry.ims.dto.seller;

//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
public class SellerRequestDTO {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
