package com.ZealIndia.Zeal_Ecommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ZealIndia.Zeal_Ecommerce.Entity.ProductSubCategory;

@Repository
public interface ProductSubCategoryRepository extends JpaRepository<ProductSubCategory, Long>
{
	 List<ProductSubCategory> findByProductCategoryId(Long productCategoryId);
}
