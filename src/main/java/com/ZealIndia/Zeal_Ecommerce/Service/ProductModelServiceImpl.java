package com.ZealIndia.Zeal_Ecommerce.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductModelDTO;
import com.ZealIndia.Zeal_Ecommerce.Entity.ProductModelBolting;
import com.ZealIndia.Zeal_Ecommerce.Entity.ProductDriveSizeBolting;
import com.ZealIndia.Zeal_Ecommerce.Repository.ProductDriveSizeBoltingRepository;
import com.ZealIndia.Zeal_Ecommerce.Repository.ProductModelBoltingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductModelServiceImpl implements ProductModelService {

    private final ProductModelBoltingRepository modelRepository;
    private final ProductDriveSizeBoltingRepository driveSizeRepository;

    private static final Logger log =
            LoggerFactory.getLogger(ProductModelServiceImpl.class);

    @Override
    public List<ProductModelDTO> getProductsBySubCategoryId(Long subCategoryId) {

        log.info("ProductModelServiceImpl | Starting Product Model fetch | subCategoryId={}", subCategoryId);

        List<ProductModelDTO> response =
                modelRepository.findByProductSubCategoryId(subCategoryId)
                        .stream()
                        .map(this::mapToDTO)
                        .collect(Collectors.toList());

        log.info("Completed Product Model fetch | count={}", response.size());
        return response;
    }

    private ProductModelDTO mapToDTO(ProductModelBolting model) {

        String driveSize = driveSizeRepository
                .findByProductModelId(model.getId())
                .stream()
                .map(ProductDriveSizeBolting::getDriveSize)
                .findFirst()
                .orElse("N/A");

        return ProductModelDTO.builder()
                .id(model.getId())
                .name(model.getModel())
                .model(model.getModel())
                .description(model.getModelDescription())
                .image(resolveImage(model.getImagePath()))
                .driveSize(driveSize)
                .torqueLbsMin(String.valueOf(model.getTorqueLbsMin()))
                .torqueLbsMax(String.valueOf(model.getTorqueLbsMax()))
                .torqueNmMin(String.valueOf(model.getTorqueNmMin()))
                .torqueNmMax(String.valueOf(model.getTorqueNmMax()))
                .toolWeightKg(String.valueOf(model.getToolWeightKg()))
                .price(model.getModelPrice())
                .link("/products/" + slugify(model.getModel()))
                .build();
    }

    private String resolveImage(String path) {
        return (path == null || path.isBlank())
                ? "/images/Products/default-product.png"
                : path;
    }

    private String slugify(String value) {
        return value.toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
    }
}
