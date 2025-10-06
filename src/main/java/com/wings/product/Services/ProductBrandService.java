package com.wings.product.Services;

import com.wings.product.Dto.ProductBrandDto;
import com.wings.product.Entity.ProductBrandEntity;
import com.wings.product.Repositorys.ProductBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductBrandService {
    @Autowired
    public ProductBrandRepository productBrandRepository ;

    public ProductBrandEntity ProductBrandSave(ProductBrandDto newBrand){
        String brandName = newBrand.getProductBrandName() ;
        String brandCode = newBrand.getProductBrandCode() ;
        Boolean brandIsActive = newBrand.isProductIsActive();
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
        //check uniqueness
        if(productBrandRepository.existsByProductBrandName(brandName)){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Error: Product brand name already exists"
            );
        }
        if(productBrandRepository.existsByProductBrandCode(brandCode)){
            throw  new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Error : Product brand code already exists"
            );
        }
        // create and save DB
        ProductBrandEntity brandEntity  = new ProductBrandEntity();
        // set the params
        brandEntity.setProductCode(brandCode);
        brandEntity.setProductName(brandName);
        brandEntity.setProductIsActive(brandIsActive);
        return productBrandRepository.save(brandEntity);
    }
    public List<ProductBrandEntity> getBrands(){
        return  productBrandRepository.findAll() ;
    }
    public  ProductBrandEntity getProductBrandById(Long id){
        return  productBrandRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found with id: " + id));
    }
}
