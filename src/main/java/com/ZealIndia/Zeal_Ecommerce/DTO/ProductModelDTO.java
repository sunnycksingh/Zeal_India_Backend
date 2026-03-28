package com.ZealIndia.Zeal_Ecommerce.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ProductModelDTO {

    private Long id;
    private String name;
    private String model;
    private String description;
    private String image;
    private String driveSize;

    private String torqueLbsMin;
    private String torqueLbsMax;
    private String torqueNmMin;
    private String torqueNmMax;

    private String toolWeightKg;
    private Double price;
    private String link;
}
