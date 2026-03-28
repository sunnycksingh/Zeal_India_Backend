package com.ZealIndia.Zeal_Ecommerce.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT_SUBCATEGORIES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSubCategory 
{
	@Id
    @Column(name = "PRODSUBCAT_ID")
    private Long productsubcat_id;

    @Column(name = "PRODSUBCAT_NAME", nullable = false)
    private String productsubcat_name;

    @Column(name = "PRODSUBCAT_PRODCAT_ID", nullable = false)
    private Long productCategoryId;

    @Column(name = "PRODSUBCAT_IMGPATH")
    private String productsubcat_imagePath;

    @Column(name = "PRODSUBCAT_DESC", length = 2000)
    private String productsubcat_description;

}
