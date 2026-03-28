package com.ZealIndia.Zeal_Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ZealIndia.Zeal_Ecommerce.Entity.ProductModelBolting;

@Repository
public interface ProductModelBoltingRepository
        extends JpaRepository<ProductModelBolting, Long> {

    List<ProductModelBolting> findByProductSubCategoryId(Long productSubCategoryId);
}
