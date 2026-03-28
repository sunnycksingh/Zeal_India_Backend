package com.ZealIndia.Zeal_Ecommerce.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductDetailsDTO;
import com.ZealIndia.Zeal_Ecommerce.Service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*") 
public class ProductController 
{

	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ProductDetailsDTO getProductDetails(@PathVariable Long id) {
    	System.out.println("Product controller : pid" +id);
        return productService.getProductDetails(id);
    }
}
