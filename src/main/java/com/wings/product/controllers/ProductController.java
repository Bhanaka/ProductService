package com.wings.product.controllers;

import com.wings.product.Dto.ProductRequestDto;
import com.wings.product.Entity.ProductItemEntity;
import com.wings.product.Services.ProductItemService;
import com.wings.product.common.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product/item")
public class ProductController {
    @Autowired
    public ProductItemService itemService ;
    // get all products
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ProductItemEntity>>> getAllProduct(){
            List<ProductItemEntity> items = itemService.getAllItems();
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.OK.value(),items, "Items fetched successfully")); // 200 ok

    }
    // create product
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<ProductItemEntity>> createProduct(@RequestBody ProductRequestDto requestDto){
            //success response
            ProductItemEntity item = itemService.createItem(requestDto);
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(), item , "Item created successfully")); //201 create
    }
    //get product by id
    @GetMapping("id/{id}")
    public ResponseEntity<ApiResponse<ProductItemEntity>> getById(@PathVariable Long id){
            // success response
            ProductItemEntity itemEntity = itemService.getItem(id);
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value(),itemEntity ,"Item fetched successfully"));
    }
    // update product by id
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ProductItemEntity>> updateProduct(@PathVariable Long id ,@RequestBody ProductRequestDto requestDto){
            // success response
            ProductItemEntity item = itemService.updateItem(id,requestDto);
            return ResponseEntity.ok(ApiResponse.success(HttpStatus.CREATED.value() ,item ,"Item updated successfully "));
    }
    // delete product by id
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Long>> deleteProduct(@PathVariable  Long id){
        // success response
        Long item = itemService.deleteItem(id) ;
        return ResponseEntity.ok(ApiResponse.success(HttpStatus.CONTINUE.value(), item , "Item deleted successfully"));

    }
}
