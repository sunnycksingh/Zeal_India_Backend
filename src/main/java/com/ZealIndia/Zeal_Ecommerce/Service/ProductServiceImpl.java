package com.ZealIndia.Zeal_Ecommerce.Service;

import org.springframework.stereotype.Service;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductDto;
import com.ZealIndia.Zeal_Ecommerce.Entity.Product;

@Service
public class ProductServiceImpl implements ProductService
{

	// ----------- Conversion Logic -------------
    private Product toEntity(ProductDto dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                dto.getPrice()
         //       dto.getStock()
        );
    }

    private ProductDto toDTO(ProductDto tool) {
    	ProductDto dto = new ProductDto();
        dto.setId(tool.getId());
        dto.setName(tool.getName());
        dto.setDescription(tool.getDescription());
        dto.setPrice(tool.getPrice());
     //   dto.setStock(tool.getStock());
        return dto;
    }
    // -------------------------------------------
}
