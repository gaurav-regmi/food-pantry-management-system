package com.pantry.ims.service.impl;

import com.pantry.ims.dto.sellerregistry.SellerRegistryRequestDTO;
import com.pantry.ims.dto.sellerregistry.SellerRegistryResponseDTO;
import com.pantry.ims.entity.SellerRegistryEntity;
import com.pantry.ims.repository.SellerRegistryRepository;
import com.pantry.ims.service.SellerRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SellerRegistryServiceImpl implements SellerRegistryService {

@Autowired
private SellerRegistryRepository sellerRegistryRepository;
    @Override
    public void SaveInfo(SellerRegistryRequestDTO sellerRegistryRequestDTO){
     SellerRegistryEntity sellerRegistryEntity = new SellerRegistryEntity();
     sellerRegistryEntity.setFoodName(sellerRegistryRequestDTO.getFoodName());
     sellerRegistryEntity.setSellerDetails(sellerRegistryRequestDTO.getSellerDetails());
     sellerRegistryRepository.save(sellerRegistryEntity);
    }
    @Override
    public List<SellerRegistryResponseDTO> GetInfo(){
        List<SellerRegistryEntity> sellerRegistryEntityList =sellerRegistryRepository.findAll();
        List<SellerRegistryResponseDTO> sellerRegistryResponseDTOList = new ArrayList();
        for(SellerRegistryEntity sellerRegistryEntity:sellerRegistryEntityList){
            SellerRegistryResponseDTO sellerRegistryResponseDTO= new SellerRegistryResponseDTO();
            sellerRegistryResponseDTO.setId(sellerRegistryEntity.getId());
            sellerRegistryResponseDTO.setFoodName(sellerRegistryEntity.getFoodName());
            sellerRegistryResponseDTO.setSellerDetails(sellerRegistryEntity.getSellerDetails());

            sellerRegistryResponseDTOList.add(sellerRegistryResponseDTO);
        }
        return sellerRegistryResponseDTOList;
    }
}
