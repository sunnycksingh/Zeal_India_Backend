package com.ZealIndia.Zeal_Ecommerce.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productmodel_drivesize_bolting_trial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDriveSizeBolting 
{
    @Id
    @Column(name = "pmds_id")
    private Long id;

 //   @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "productmodel_id")
    private Long productModelId;

    @Column(name = "drive_size")
    private String driveSize;

}
