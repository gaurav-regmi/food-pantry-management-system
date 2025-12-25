package com.pantry.ims.controller;

import com.pantry.ims.dto.seller.SellerRequestDTO;
import com.pantry.ims.dto.seller.SellerResponseDTO;
import com.pantry.ims.entity.SellerEntity;
import com.pantry.ims.repository.SellerRepository;
import com.pantry.ims.service.SellerService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("seller")
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerService sellerService;

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String SaveInfo(@RequestBody SellerRequestDTO sellerRequest) {
        sellerService.saveSeller(sellerRequest);

        return "Your seller information is saved.";
    }


    @GetMapping(value = "info")
    public List<SellerResponseDTO> DisplaySellerInfo() {
        return sellerService.sellerInfo();
    }
}
