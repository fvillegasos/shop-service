package com.fvillegasos.shop_service.repository;

import com.fvillegasos.shop_service.entity.ProductPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPriceEntity, Long> {

    @Query(value = "SELECT price from ProductPriceEntity price WHERE " +
            "price.product.productId = :productId AND " +
            "price.brand.brandId = :brandId AND " +
            "price.startDate <= :applicationDate AND " +
            "price.endDate >= :applicationDate " +
            "ORDER BY price.priority DESC LIMIT 1")
    Optional<ProductPriceEntity> findPriorityProductPriceByFilters(Long productId, Long brandId, LocalDateTime applicationDate);

}
