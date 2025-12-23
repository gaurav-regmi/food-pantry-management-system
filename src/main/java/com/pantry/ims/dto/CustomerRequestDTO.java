package com.pantry.ims.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO extends ModelBase{
    private String username;
    private String password;

    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String gender;
    private String dob;
    private String phone;
    private String country;
    private String state;
    private String zipCode;
}
