package com.wings.product.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("product/brand")
@Slf4j // for log
public class ProductBrandController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
    @GetMapping("/docker")
    public String createDocker(){
        return " Hi docker" ;
    }
    @PostMapping("/create")
    public void createProductBrand(){

    }
    @GetMapping("/getAllBrands")
    public void getAllProductBrands(){}
    @GetMapping("/getById/{id}")
    public void getProductBrandById(){}
    @PutMapping("/update")
    public void updateProductBrand(){}
    @DeleteMapping("/delete")
    public void deleteProductBrandById(){}

}
