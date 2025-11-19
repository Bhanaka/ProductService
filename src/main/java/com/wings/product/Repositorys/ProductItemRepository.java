package com.wings.product.Repositorys;

import com.wings.product.Entity.ProductItemEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItemEntity,Long> {
    boolean existsByProductCode(String itemCode);
    boolean existsByProductName(String itemName);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tb_product_brand " +
                    "SET is_active = false" +
                    "WHERE id = :id",
            nativeQuery = true
    )
    Long deleteItem(
            @Param("id") Long id
    );
}
