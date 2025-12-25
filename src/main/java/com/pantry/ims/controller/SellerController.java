package com.pantry.ims.controller;

import com.pantry.ims.dto.seller.SellerRequestDTO;
import com.pantry.ims.dto.seller.SellerResponseDTO;
import com.pantry.ims.entity.SellerEntity;
import com.pantry.ims.repository.SellerRepository;
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

    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String SaveInfo(@RequestBody SellerRequestDTO sellerRequest) {
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setName(sellerRequest.getName());
        sellerEntity.setAddress(sellerRequest.getAddress());
        sellerRepository.save(sellerEntity);

        return "Your seller information is saved.";
    }

    @GetMapping(value = "info")
    public List<SellerResponseDTO> DisplaySellerInfo() {
        List<SellerEntity> sellerEntityList = sellerRepository.findAll();

        List<SellerResponseDTO> sellerResponseDTOList = new ArrayList<>();

        for (SellerEntity sellerEntity : sellerEntityList) {
            SellerResponseDTO sellerResponseDTO = new SellerResponseDTO();
            sellerResponseDTO.setId(sellerEntity.getId());
            sellerResponseDTO.setName(sellerEntity.getName());
            sellerResponseDTO.setAddress(sellerEntity.getAddress());

            sellerResponseDTOList.add(sellerResponseDTO);

        }
        return sellerResponseDTOList;
    }
}
