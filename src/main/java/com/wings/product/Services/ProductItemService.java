package com.wings.product.Services;

import com.wings.product.Dto.ProductRequestDto;
import com.wings.product.Entity.ProductItemEntity;
import com.wings.product.Repositorys.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemService {
    @Autowired
    public ProductItemRepository itemRepository ;

    public ProductItemEntity createItem(ProductRequestDto requestDto){

        // check existing product code
        if(itemRepository.existsByProductCode(requestDto.getProductCode())){
            throw new RuntimeException("Product code already exists");
        }
        if(itemRepository.existsByProductName(requestDto.getProductName())){
            throw new RuntimeException("Product name already exists");
        }
        ProductItemEntity itemEntity = new ProductItemEntity();

        itemEntity.setProductCode(requestDto.getProductCode());
        itemEntity.setProductName(requestDto.getProductName());
        itemEntity.setProductDescription(requestDto.getProductDesc());
        itemEntity.setProductBuyPrice(requestDto.getProductBuyPrice());
        itemEntity.setProductSellingPrice(requestDto.getProductSellingPrice());
        itemEntity.setProductDiscount(requestDto.getProductDiscount());
        itemEntity.setProductIsActive(requestDto.getProductIsActive());
        itemEntity.setProductUserId(requestDto.getProductUserId());
        itemEntity.setProductBrandId(requestDto.getProductBrandId());
        return itemRepository.save(itemEntity);
    }

    public ProductItemEntity getItem(Long id){
        Optional<ProductItemEntity> item = itemRepository.findById(id);
        if(item.isPresent()){
            return item.get() ;
        }else {
            throw new RuntimeException("Product item not found for ID: " + id);        }
    }
    public List<ProductItemEntity>getAllItems(){
        List<ProductItemEntity> items = itemRepository.findAll();

        if(items.isEmpty()){
            throw new RuntimeException("Product items list is Empty");
        }
        return  items;
    }
    public ProductItemEntity updateItem(Long id ,ProductRequestDto updateItem){
        ProductItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product item not found for ID: " + id));

        item.setProductCode(updateItem.getProductCode());
        item.setProductName(updateItem.getProductName());
        item.setProductDescription(updateItem.getProductDesc());
        item.setProductBuyPrice(updateItem.getProductBuyPrice());
        item.setProductSellingPrice(updateItem.getProductSellingPrice());
        item.setProductDiscount(updateItem.getProductDiscount());
        item.setProductIsActive(updateItem.getProductIsActive());
        item.setProductUserId(updateItem.getProductUserId());
        item.setProductBrandId(updateItem.getProductBrandId());

        return itemRepository.save(item);
    }
}
