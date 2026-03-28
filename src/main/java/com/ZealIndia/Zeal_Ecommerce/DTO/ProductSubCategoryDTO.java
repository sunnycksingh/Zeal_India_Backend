package com.ZealIndia.Zeal_Ecommerce.DTO;

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
public class ProductSubCategoryDTO 
{
	private Long id;
    private String title;
    private String description;
    private String image;
    private String link;

}
