package com.pantry.ims.controller;

import com.pantry.ims.builder.ResponseBuilder;
import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.dto.CustomerResponseDTO;
import com.pantry.ims.dto.ServerResponse;
import com.pantry.ims.repository.CustomerRepository;
import com.pantry.ims.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerService customerService;


    @PostMapping(value = "signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        ServerResponse serverResponse = customerService.saveCustomer(customerRequestDTO);
        return ResponseBuilder.response(serverResponse);
    }

    @GetMapping(value = "info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerResponseDTO>> customerInfo() {

        return ResponseEntity.ok(null);
    }

}
