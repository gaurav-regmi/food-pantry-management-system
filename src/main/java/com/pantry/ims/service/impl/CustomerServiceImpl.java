package com.pantry.ims.service.impl;

import com.pantry.ims.builder.ResponseMsg;
import com.pantry.ims.constant.MsgConstant;
import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.dto.ServerResponse;
import com.pantry.ims.entity.Customer;
import com.pantry.ims.mapper.CustomerMapper;
import com.pantry.ims.repository.CustomerRepository;
import com.pantry.ims.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ServerResponse saveCustomer(CustomerRequestDTO customerRequestDTO) {
        Optional<Customer> customerOptional = customerRepository.findActiveCustomerByUsername(customerRequestDTO.getUsername());

        if (customerOptional.isPresent()) {
            return ResponseMsg.failure(MsgConstant.Customer.ALREADY_EXISTS);
        }

        Customer customer = CustomerMapper.mapToCustomer(customerRequestDTO);
        customerRepository.save(customer);

        return ResponseMsg.success(MsgConstant.Customer.CUSTOMER_SAVED_SUCCESSFULLY);
    }
}
