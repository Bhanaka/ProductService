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
        try{
            List<ProductItemEntity> items = itemService.getAllItems();
            //success response
            ApiResponse<List<ProductItemEntity>> response = ApiResponse.<List<ProductItemEntity>>builder()
                    .status("201")
                    .message("Items fetched successfully")
                    .data(items)
                    .build();
            return  ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            // Error response
            ApiResponse<List<ProductItemEntity>> response = ApiResponse.<List<ProductItemEntity>>builder()
                    .status("error")
                    .message(e.getMessage())
                    .data(null)
                    .build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

        }
    }
//    // create product
//    @PostMapping("/create")
//    public ResponseEntity<ProductItemEntity> createProduct(@RequestBody ProductRequestDto requestDto){
//        return itemService.createItem(requestDto);
//    }
//    //get product by id
//    @GetMapping("id/{id}")
//    public ResponseEntity<ProductItemEntity> getById(@PathVariable Long id){
//        return itemService.getItem(id);
//    }
//    // update product by id
//    @PutMapping("/update/{id}")
//    public ResponseEntity<ProductItemEntity> updateProduct(@PathVariable Long id ,@RequestBody ProductRequestDto requestDto){
//        return itemService.updateItem(id,requestDto);
//    }
//    // delete product by id
//    @DeleteMapping("/delete")
//    public void deleteProduct(){}
}
