package com.wings.product.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
