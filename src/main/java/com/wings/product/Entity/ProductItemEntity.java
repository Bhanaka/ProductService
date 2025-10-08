package com.wings.product.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product_item")
public class ProductItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id ;
    @Column(name = "code" ,unique = true , nullable = false)
    private String productCode ;
    @Column(name = "name" , unique = true ,nullable = false)
    private String productName ;
    @Column(name = "description" )
    private String productDescription ;
    @Column(name = "buy_price" ,nullable = false)
    private Double productBuyPrice ;
    @Column(name = "selling_price" , nullable = false)
    private Double productSellingPrice ;
    @Column(name = "image")
    private String productImage ;
    @Column(name = "discount")
    private Double productDiscount ;
    @Column(name = "indate", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime indate;
    @Column(name = "is_active")
    private boolean productIsActive ;
    @Column(name = "user_id")
    private Integer productUserId ;
    @Column(name = "brand_id")
    private Integer productBrandId ;
    @Column(name = "last_edit_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime productEditDate;

}
