package com.ZealIndia.Zeal_Ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductSubCategoryDTO;
import com.ZealIndia.Zeal_Ecommerce.Service.ProductSubCategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subcategories")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ProductSubCategoryController 
{
	 private final ProductSubCategoryService service;
	 
	@GetMapping("/{categoryId}")
    public List<ProductSubCategoryDTO> getSubCategories(@PathVariable Long categoryId)
    {
        return service.getSubCategoriesByCategoryId(categoryId);
    }
	 
}
