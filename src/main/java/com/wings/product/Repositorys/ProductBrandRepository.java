package com.wings.product.Repositorys;

import com.wings.product.Entity.ProductBrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBrandRepository extends JpaRepository<ProductBrandEntity,Long> {
    //native query
    @Query(
            value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM tb_product_brand " +
                    "WHERE name = :productName",
            nativeQuery = true
    )
    boolean existsByProductBrandName(@Param("productName") String productName);
    @Query(
            value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END " +
                    "FROM tb_product_brand " +
                    "WHERE code = :brandCode",
            nativeQuery = true
    )
    boolean existsByProductBrandCode(String brandCode);

}
