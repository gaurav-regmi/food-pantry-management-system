package com.pantry.ims.controller;

import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.dto.CustomerResponseDTO;
import com.pantry.ims.entity.CustomerEntity;
import com.pantry.ims.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customerRequestDTO.getName());
        customerEntity.setAddress(customerRequestDTO.getAddress());

        customerRepository.save(customerEntity);
        return "Customer saved successfully";
    }

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerResponseDTO>> customerInfo() {
        List<CustomerEntity> customerEntityList = customerRepository.findAll();

        List<CustomerResponseDTO> customerResponseDTOList = new ArrayList<>();

        for(CustomerEntity customerEntity: customerEntityList){
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            customerResponseDTO.setId(customerEntity.getId());
            customerResponseDTO.setName(customerEntity.getName());
            customerResponseDTO.setAddress(customerEntity.getAddress());

            customerResponseDTOList.add(customerResponseDTO);
        }

        return ResponseEntity.ok(customerResponseDTOList);
    }

}
