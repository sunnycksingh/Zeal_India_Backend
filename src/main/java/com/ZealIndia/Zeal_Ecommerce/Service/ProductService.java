package com.ZealIndia.Zeal_Ecommerce.Service;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductDetailsDTO;

public interface ProductService {
	ProductDetailsDTO getProductDetails(Long productId);
}
