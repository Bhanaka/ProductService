package com.wings.product.Services;

import com.wings.product.Dto.ProductRequestDto;
import com.wings.product.Entity.ProductItemEntity;
import com.wings.product.Repositorys.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemService {
    @Autowired
    public ProductItemRepository itemRepository ;

//    public ResponseEntity<ProductItemEntity> createItem(ProductRequestDto requestDto){
//        ProductItemEntity itemEntity = new ProductItemEntity();
//        itemEntity.setProductCode(requestDto.getProductCode());
//        itemEntity.setProductName(requestDto.getProductName());
//        itemEntity.setProductDescription(requestDto.getProductDesc());
//        itemEntity.setProductBuyPrice(requestDto.getProductBuyPrice());
//        itemEntity.setProductSellingPrice(requestDto.getProductSellingPrice());
//        itemEntity.setProductDiscount(requestDto.getProductDiscount());
//        itemEntity.setProductIsActive(requestDto.getProductIsActive());
//        itemEntity.setProductUserId(requestDto.getProductUserId());
//        itemEntity.setProductBrandId(requestDto.getProductBrandId());
//
//        return itemRepository.save(itemEntity);
//    }

    public ProductItemEntity getItem(Long id){
        return itemRepository.getById(id);
    }
    public List<ProductItemEntity>getAllItems(){
        List<ProductItemEntity> items = itemRepository.findAll();

        if(items.isEmpty()){
            throw new RuntimeException("Product items list is Empty");
        }
        return  items;
    }
//    public ProductItemEntity updateItem(Long id ,ProductItemEntity updateItem){
//        return
//    }
}
