package com.pantry.ims.controller;

import com.pantry.ims.dto.customer.CustomerResponseDTO;
import com.pantry.ims.dto.sellerregistry.SellerRegistryRequestDTO;
import com.pantry.ims.dto.sellerregistry.SellerRegistryResponseDTO;
import com.pantry.ims.service.SellerRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seller_registry")
public class SellerRegistryController {

    //add 4 crud apis
    // info of food, seller details
    // save, info, modify, delete
    @Autowired
    private SellerRegistryService sellerRegistryService;

    @GetMapping(value = "info")
    public List<SellerRegistryResponseDTO> Get_theInfo() {

        return sellerRegistryService.GetInfo();

    }


    @PostMapping(value = "save")
    public String Save_theInfo(@RequestBody SellerRegistryRequestDTO sellerRegistryRequestDTO) {
        sellerRegistryService.SaveInfo(sellerRegistryRequestDTO);
        return "Your information is saved.";
    }
}

