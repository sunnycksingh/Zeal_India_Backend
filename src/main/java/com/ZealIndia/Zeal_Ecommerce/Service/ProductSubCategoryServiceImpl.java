package com.ZealIndia.Zeal_Ecommerce.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ZealIndia.Zeal_Ecommerce.DTO.ProductSubCategoryDTO;
import com.ZealIndia.Zeal_Ecommerce.Repository.ProductSubCategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductSubCategoryServiceImpl implements ProductSubCategoryService {

	private final ProductSubCategoryRepository repository;
	
	private static final Logger log 		= LoggerFactory.getLogger(ProductSubCategoryServiceImpl.class);
	
	@Override
    public List<ProductSubCategoryDTO> getSubCategoriesByCategoryId(Long categoryId) 
	{

		log.info("Starting Product Subcategory fetching | type=FETCH_SUBCATEGORIES ",
				categoryId);
		
		List<ProductSubCategoryDTO> productSubCategoryData = repository.findByProductCategoryId(categoryId)
											                .stream()
											                .map(subCat -> new ProductSubCategoryDTO(
											                        subCat.getProductsubcat_id(),
											                        subCat.getProductsubcat_name(),
											                        subCat.getProductsubcat_description(),
											                        resolveImage(subCat.getProductsubcat_imagePath()),
											                        "/products/" + slugify(subCat.getProductsubcat_name())
											                ))
											                .collect(Collectors.toList());
		
		log.info("Completed Product Subcategory fetching | type=FETCH_SUBCATEGORIES | productSubCategoryData {}",
				productSubCategoryData);
		
        return productSubCategoryData;
    }
	
    private String resolveImage(String path) 
    {
        return (path == null || path.isBlank())
                ? "/images/SubCategories/BoltingSubCategories/MainBoltTensionor.png"
                : path;
    }

    private String slugify(String value) 
    {
        return value.toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");
    }
	
}
