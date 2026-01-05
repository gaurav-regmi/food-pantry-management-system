package com.pantry.ims.controller;

import com.pantry.ims.dto.sellerregistry.SellerRegistryRequestDTO;
import com.pantry.ims.dto.sellerregistry.SellerRegistryResponseDTO;
import com.pantry.ims.service.SellerRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getInfo() {
        List<SellerRegistryResponseDTO> sellerRegistryResponseDTOList = sellerRegistryService.GetInfo();

        return new ResponseEntity<>(sellerRegistryResponseDTOList, HttpStatus.OK);
    }


    @PostMapping(value = "save")
    public ResponseEntity<?> saveInfo(@RequestBody SellerRegistryRequestDTO sellerRegistryRequestDTO) {
        sellerRegistryService.SaveInfo(sellerRegistryRequestDTO);
        return new ResponseEntity<>("Your information is saved.", HttpStatus.OK);
    }
}

