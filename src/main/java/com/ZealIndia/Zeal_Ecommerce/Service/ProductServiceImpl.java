package com.ZealIndia.Zeal_Ecommerce.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductDetailsDTO;
import com.ZealIndia.Zeal_Ecommerce.Entity.ProductDriveSizeBolting;
import com.ZealIndia.Zeal_Ecommerce.Entity.ProductModelBolting;
import com.ZealIndia.Zeal_Ecommerce.Repository.ProductDriveSizeBoltingRepository;
import com.ZealIndia.Zeal_Ecommerce.Repository.ProductModelBoltingRepository;

@Service
public class ProductServiceImpl implements ProductService
{

    private final ProductModelBoltingRepository productRepository;
    private final ProductDriveSizeBoltingRepository driveSizeRepository;

    public ProductServiceImpl(ProductModelBoltingRepository productRepository,
                              ProductDriveSizeBoltingRepository driveSizeRepository) 
    {
        this.productRepository = productRepository;
        this.driveSizeRepository = driveSizeRepository;
    }

    @Override
    public ProductDetailsDTO getProductDetails(Long productId) 
    {
        ProductModelBolting product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Fetch drive sizes
//	        var driveSizes = driveSizeRepository.findByProductModelId(productId)
//	                .stream()
//	                .map(ProductDriveSizeBolting::getDriveSize)
//	                .collect(Collectors.toList());

        List<String> driveSizes = driveSizeRepository
                .findByProductModelId(productId)
                .stream()
                .map(ProductDriveSizeBolting::getDriveSize)
                .collect(Collectors.toList());
        
                
        // Map to DTO
        ProductDetailsDTO dto = new ProductDetailsDTO();
        dto.setId(product.getId());
        dto.setModel(product.getModel());
        dto.setModelWidth(product.getModelWidth());
        dto.setTorqueLbsMin(product.getTorqueLbsMin());
        dto.setTorqueLbsMax(product.getTorqueLbsMax());
        dto.setTorqueNmMin(product.getTorqueNmMin());
        dto.setTorqueNmMax(product.getTorqueNmMax());
        dto.setToolWeightKg(product.getToolWeightKg());
        dto.setModelDescription(product.getModelDescription());
        dto.setModelPrice(product.getModelPrice());
        dto.setImagePath(product.getImagePath());
//	    dto.setSubcategoryName(product.getSubcategory() != null ? product.getSubcategory().getName() : null);
        dto.setDriveSizes(driveSizes);

        System.out.print("ProductDetailsDTO >> driveSizes: "+driveSizes);
        System.out.println("ProductDetailsDTO >> productModel(): "+product.getModel());
        
        return dto;
    }
}