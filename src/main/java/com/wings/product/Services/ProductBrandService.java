package com.wings.product.Services;

import com.wings.product.Dto.ProductBrandDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductBrandService {
    public void ProductBrandSave(ProductBrandDto newBrand){
        String brandName = newBrand.getProductBrandName() ;
        String brandCode = newBrand.getProductBrandCode() ;

        // validate requested input
        if(!StringUtils.hasText(brandName)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Brand Name must be Required "
            );
        }
        if(!StringUtils.hasText(brandCode)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Brand Code must be required "
            );
        }

    }
}
