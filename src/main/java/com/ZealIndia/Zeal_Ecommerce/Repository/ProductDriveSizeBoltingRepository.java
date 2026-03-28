package com.ZealIndia.Zeal_Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ZealIndia.Zeal_Ecommerce.Entity.ProductDriveSizeBolting;

public interface ProductDriveSizeBoltingRepository
        extends JpaRepository<ProductDriveSizeBolting, Long> {

    List<ProductDriveSizeBolting> findByProductModelId(Long productModelId);
}
