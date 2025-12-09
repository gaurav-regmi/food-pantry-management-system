package com.pantry.ims.controller;

import com.pantry.ims.dto.*;
import com.pantry.ims.entity.CustomerEntity;
import com.pantry.ims.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        for (CustomerEntity customerEntity : customerEntityList) {
            CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
            customerResponseDTO.setId(customerEntity.getId());
            customerResponseDTO.setName(customerEntity.getName());
            customerResponseDTO.setAddress(customerEntity.getAddress());

            customerResponseDTOList.add(customerResponseDTO);
        }

        return ResponseEntity.ok(customerResponseDTOList);
    }

    @PutMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateCustomer(@RequestBody CustomerModifyDTO modifyDTO) {
        try {
            Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(modifyDTO.getId());

            CustomerResponseDTO responseDTO = new CustomerResponseDTO();

            if (optionalCustomerEntity.isEmpty()) {
                //throw a not found message;
                responseDTO.setMessage("Customer not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDTO);
            }

            CustomerEntity customerEntity = optionalCustomerEntity.get();
            customerEntity.setName(modifyDTO.getName());
            customerEntity.setAddress(modifyDTO.getAddress());

            CustomerEntity updatedCustomer = customerRepository.save(customerEntity);


            responseDTO.setName(updatedCustomer.getName());
            responseDTO.setAddress(updatedCustomer.getAddress());
            responseDTO.setMessage("Customer updated successfully");

            return ResponseEntity.ok(responseDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error");
        }


    }

    @DeleteMapping(value = "delete")
    public CustomerDeleteResponseDTO deleteCustomer(@RequestBody CustomerDeleteDTO deleteDTO) {
        Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(deleteDTO.getId());
        if (optionalCustomerEntity.isEmpty()) {
            CustomerDeleteResponseDTO customerDeleteResponseDTO = new CustomerDeleteResponseDTO();
            customerDeleteResponseDTO.setMessage("Customer not found");
            return customerDeleteResponseDTO;

        }
        CustomerEntity customer = optionalCustomerEntity.get();
        customerRepository.delete(customer);

        CustomerDeleteResponseDTO customerDeleteResponseDTO = new CustomerDeleteResponseDTO();
        customerDeleteResponseDTO.setMessage("Customer deleted successfully");
        return customerDeleteResponseDTO;

    }


}
