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
//        try{
            List<ProductItemEntity> items = itemService.getAllItems();
            //success response
            return ResponseEntity.ok(ApiResponse.success(200,items, "Items fetched successfully"));
//
//        } catch (RuntimeException e) {
//            // Error response
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(ApiResponse.error(e.getMessage()));
//        }
    }
    // create product
//    @PostMapping("/create")
//    public ResponseEntity<ApiResponse<ProductItemEntity>> createProduct(@RequestBody ProductRequestDto requestDto){
//        try{
//            //success response
//            ProductItemEntity item = itemService.createItem(requestDto);
//            return ResponseEntity.ok(ApiResponse.success(item , "Item created successfully"));
//        } catch (RuntimeException e) {
//            // Error response
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(ApiResponse.error(e.getMessage()));
//        }
//    }
    //get product by id
//    @GetMapping("id/{id}")
//    public ResponseEntity<ApiResponse<ProductItemEntity>> getById(@PathVariable Long id){
//        try {
//            ProductItemEntity itemEntity = itemService.getItem(id) ;
//            return ResponseEntity.ok(ApiResponse.success(itemEntity , "get item by id"));
//        } catch (RuntimeException e) {
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(ApiResponse.error(e.getMessage()));
//        }
//    }
    // update product by id
//    @PutMapping("/update/{id}")
//    public ResponseEntity<ApiResponse<ProductItemEntity>> updateProduct(@PathVariable Long id ,@RequestBody ProductRequestDto requestDto){
//        try{
//            ProductItemEntity item = itemService.updateItem(id,requestDto);
//            return ResponseEntity.ok(ApiResponse.success(item ,"successfully update"));
//
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body(ApiResponse.error(e.getMessage()));
//        }
//    }
//    // delete product by id
//    @DeleteMapping("/delete")
//    public void deleteProduct(){}
}
