package com.ZealIndia.Zeal_Ecommerce.Entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productmodel_bolting_trialtable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductModelBolting {

    @Id
    @Column(name = "pm_id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "model_width")
    private String modelWidth;

    @Column(name = "torque_lbs_min")
    private Long torqueLbsMin;

    @Column(name = "torque_lbs_max")
    private Long torqueLbsMax;

    @Column(name = "torque_nm_min")
    private Double torqueNmMin;

    @Column(name = "torque_nm_max")
    private Long torqueNmMax;

    @Column(name = "tool_wght_kg")
    private Double toolWeightKg;

    @Column(name = "model_description", length = 3000)
    private String modelDescription;

    @Column(name = "model_price")
    private Double modelPrice;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "prodsubcat_id")
    private Long productSubCategoryId;
    
//    @OneToMany(mappedBy = "productModelId", fetch = FetchType.LAZY)
//    private List<ProductDriveSizeBolting> driveSizes;
}


//torque_lbf_min	torque_lbf_max					
//operation	reserve_size	control_valve	type_valve	motor_specs	flow_rate_600psi	flow_rate_10000psi	