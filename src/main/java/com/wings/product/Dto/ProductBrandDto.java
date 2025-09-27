package com.wings.product.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductBrandDto {
    private Integer productBrandId ;
    private String productBrandName ;
    private String productBrandCode ;
    private boolean productIsActive ;
}
