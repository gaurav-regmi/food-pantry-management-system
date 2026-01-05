package com.pantry.ims.service;

import com.pantry.ims.dto.sellerregistry.SellerRegistryRequestDTO;
import com.pantry.ims.dto.sellerregistry.SellerRegistryResponseDTO;

import java.util.List;


public interface SellerRegistryService {
    public void SaveInfo(SellerRegistryRequestDTO sellerRegistryRequestDTO);

    public List<SellerRegistryResponseDTO> GetInfo();

}
