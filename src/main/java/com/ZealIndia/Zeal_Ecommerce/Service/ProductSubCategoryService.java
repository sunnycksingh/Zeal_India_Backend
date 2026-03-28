package com.ZealIndia.Zeal_Ecommerce.Service;

import java.util.List;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductSubCategoryDTO;

public interface ProductSubCategoryService 
{
	List<ProductSubCategoryDTO> getSubCategoriesByCategoryId(Long categoryId);
}
