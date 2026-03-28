package com.ZealIndia.Zeal_Ecommerce.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductDetailsDTO {
	
	   private Long id;
	    private String model;
	    private String modelWidth;
	    private Long torqueLbsMin;
	    private Long torqueLbsMax;
	    private Double torqueNmMin;
	    private Long torqueNmMax;
	    private Double toolWeightKg;
	    private String modelDescription;
	    private Double modelPrice;
	    private String imagePath;
	    private String subcategoryName;
	    private List<String> driveSizes;
}
