package com.wings.product.Repositorys;

import com.wings.product.Entity.ProductItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItemEntity,Long> {
    boolean existsByProductCode(String itemCode);
    boolean existsByProductName(String itemName);
}
