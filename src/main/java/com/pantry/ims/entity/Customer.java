package com.pantry.ims.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "USERNAME")
})
@Getter
@Setter
public class Customer extends CommonEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "USERNAME", nullable = false, length = 100)
    private String username;   // email or phone

    @Column(name = "PASSWORD", nullable = false)
    private String password;   // hashed password

    @Column(name = "FIRST_NAME", nullable = false, length = 50)
    private String firstName;

    @Column(name = "MIDDLE_NAME", length = 50)
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false, length = 50)
    private String lastName;

    @Column(name = "ADDRESS", length = 255)
    private String address;

    @Column(name = "GENDER", length = 10)
    private String gender;

    @Column(name = "DOB", length = 20)
    private LocalDate dob;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "COUNTRY", length = 50)
    private String country;

    @Column(name = "STATE", length = 50)
    private String state;

    @Column(name = "ZIP_CODE", length = 15)
    private String zipCode;

    @Column(name = "ACTIVE", nullable = false)
    private Character active;
}
