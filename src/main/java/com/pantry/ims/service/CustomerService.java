package com.pantry.ims.service;

import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.dto.ServerResponse;

public interface CustomerService {
    ServerResponse saveCustomer(CustomerRequestDTO customerRequestDTO);
}
