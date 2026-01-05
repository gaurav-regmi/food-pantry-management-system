package com.pantry.ims.repository;

import com.pantry.ims.entity.SellerRegistryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRegistryRepository extends JpaRepository<SellerRegistryEntity,Integer>{

    }

