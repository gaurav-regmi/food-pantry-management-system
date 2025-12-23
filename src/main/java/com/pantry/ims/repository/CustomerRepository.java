package com.pantry.ims.repository;

import com.pantry.ims.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select t from Customer t where t.username = :username and t.active = 'Y'")
    Optional<Customer> findActiveCustomerByUsername(String username);
}
