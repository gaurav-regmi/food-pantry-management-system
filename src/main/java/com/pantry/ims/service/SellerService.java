package com.pantry.ims.service;

import com.pantry.ims.dto.seller.SellerRequestDTO;
import com.pantry.ims.dto.seller.SellerResponseDTO;

import java.util.List;

public interface SellerService {
    void saveSeller(SellerRequestDTO sellerRequestDTO);

    List<SellerResponseDTO> sellerInfo();
}
