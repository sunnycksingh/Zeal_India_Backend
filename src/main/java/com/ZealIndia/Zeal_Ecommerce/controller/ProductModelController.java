package com.ZealIndia.Zeal_Ecommerce.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductModelDTO;
import com.ZealIndia.Zeal_Ecommerce.Service.ProductModelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ProductModelController {

    private final ProductModelService service;

    @GetMapping("/by-subcategory/{subCategoryId}")
    public List<ProductModelDTO> getProductsBySubCategory(
            @PathVariable Long subCategoryId) {

        return service.getProductsBySubCategoryId(subCategoryId);
    }
}
