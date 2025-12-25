package com.pantry.ims.controller;

import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.dto.CustomerResponseDTO;
import com.pantry.ims.dto.SellerRequestDTO;
import com.pantry.ims.dto.SellerResponseDTO;
import com.pantry.ims.entity.SellerEntity;
import com.pantry.ims.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(value = "info")
    public List<SellerResponseDTO> DisplaySellerInfo(){
        List<SellerEntity> sellerEntityList = sellerRepository.findAll();

        List<SellerResponseDTO> sellerResponseDTOList = new ArrayList<>();

        for(SellerEntity sellerEntity : sellerEntityList)
        {
            SellerResponseDTO sellerResponseDTO = new SellerResponseDTO();
            sellerResponseDTO.setId(sellerEntity.getId());
            sellerResponseDTO.setName(sellerEntity.getName());
            sellerResponseDTO.setAddress(sellerEntity.getAddress());

            sellerResponseDTOList.add(sellerResponseDTO);

        }
        return sellerResponseDTOList;

    }






}
