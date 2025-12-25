package com.pantry.ims.controller;

import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.dto.CustomerResponseDTO;
import com.pantry.ims.dto.SellerRequestDTO;
import com.pantry.ims.entity.SellerEntity;
import com.pantry.ims.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seller")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;
    @PostMapping
    public String SaveInfo(@RequestBody SellerRequestDTO sellerRequest){
        SellerEntity sellerEntity= new SellerEntity();
        sellerEntity.setName(sellerRequest.getName());
        sellerEntity.setAddress(sellerRequest.getAddress());
        sellerRepository.save(sellerEntity);
        return "Your seller information is saved.";
    }




}
