package com.wings.product.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    private Integer productId;
    private String productName;
    private String productCode;
    private String productDesc;
    private String productBrand;
    private Double productBuyPrice;
    private Double productSellingPrice;
    private String productImage;
    private Boolean productIsActive;
    private Integer productBrandId;
    private Integer productUserId ;
    private Double productDiscount ;
}
