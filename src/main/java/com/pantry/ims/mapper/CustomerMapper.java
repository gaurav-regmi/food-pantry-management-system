package com.pantry.ims.mapper;

import com.pantry.ims.constant.DateFormat;
import com.pantry.ims.dto.CustomerRequestDTO;
import com.pantry.ims.entity.Customer;
import com.pantry.ims.util.DateUtil;

public class CustomerMapper {

    public static Customer mapToCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        customer.setUsername(customerRequestDTO.getUsername());
        customer.setPassword(customerRequestDTO.getPassword());
        customer.setFirstName(customerRequestDTO.getFirstName());
        customer.setMiddleName(customerRequestDTO.getMiddleName());
        customer.setLastName(customerRequestDTO.getLastName());
        customer.setAddress(customerRequestDTO.getAddress());
        customer.setGender(customerRequestDTO.getGender());
        customer.setDob(DateUtil.parseDate(customerRequestDTO.getDob(), DateFormat.MM_DD_YYYY));
        customer.setPhone(customerRequestDTO.getPhone());
        customer.setCountry(customerRequestDTO.getCountry());
        customer.setState(customerRequestDTO.getState());
        customer.setZipCode(customerRequestDTO.getZipCode());

        return customer;
    }
}
