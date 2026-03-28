package com.ZealIndia.Zeal_Ecommerce.Service;

import java.util.List;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductModelDTO;

public interface ProductModelService {

    List<ProductModelDTO> getProductsBySubCategoryId(Long subCategoryId);
}
