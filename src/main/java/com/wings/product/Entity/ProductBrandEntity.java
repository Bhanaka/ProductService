package com.wings.product.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product_brand")
public class ProductBrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(name = "name" , unique = true ,nullable = false )
    private String productName ;
    @Column(name = "code" ,unique = true ,nullable = false)
    private String productCode ;

    @Column(name = "is_active")
    private boolean productIsActive ;
}
