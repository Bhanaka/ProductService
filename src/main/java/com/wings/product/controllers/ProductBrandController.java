package com.wings.product.controllers;

import com.wings.product.Dto.ProductBrandDto;
import com.wings.product.Entity.ProductBrandEntity;
import com.wings.product.Services.ProductBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("product/brand")
@Slf4j // for log
public class ProductBrandController {
    @Autowired
    public ProductBrandService brandService ;

    @PostMapping("/create")
    public ResponseEntity<ProductBrandEntity> createProductBrand(@RequestBody ProductBrandDto brandDto){
        ProductBrandEntity brand = brandService.ProductBrandSave(brandDto);
        return ResponseEntity.ok(brand);
    }
    @GetMapping("/getAllBrands")
    public ResponseEntity<List<ProductBrandEntity>> getAllProductBrands(){
        List<ProductBrandEntity> list = brandService.getBrands() ;
        return ResponseEntity.ok(list);
    }
    @GetMapping("/getById/{id}")
    public ProductBrandEntity getProductBrandById(@PathVariable Long id){
        return brandService.getProductBrandById(id);
    }
    @PutMapping("/update")
    public void updateProductBrand(){}
    @DeleteMapping("/delete")
    public void deleteProductBrandById(){}

}
