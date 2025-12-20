package com.ZealIndia.Zeal_Ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ZealIndia.Zeal_Ecommerce.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
