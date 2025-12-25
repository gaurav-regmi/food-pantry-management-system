package com.pantry.ims.service.impl;

import com.pantry.ims.dto.seller.SellerRequestDTO;
import com.pantry.ims.dto.seller.SellerResponseDTO;
import com.pantry.ims.entity.SellerEntity;
import com.pantry.ims.repository.SellerRepository;
import com.pantry.ims.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void saveSeller(SellerRequestDTO sellerRequestDTO) {
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setName(sellerRequestDTO.getName());
        sellerEntity.setAddress(sellerRequestDTO.getAddress());

        sellerRepository.save(sellerEntity);
    }

    @Override
    public  List<SellerResponseDTO> sellerInfo() {
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
