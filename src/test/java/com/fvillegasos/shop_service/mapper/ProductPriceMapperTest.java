package com.fvillegasos.shop_service.mapper;

import com.fvillegasos.shop_service.entity.BrandEntity;
import com.fvillegasos.shop_service.entity.ProductEntity;
import com.fvillegasos.shop_service.entity.ProductPriceEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
class ProductPriceMapperTest {

    private static final Long TEST_ID = 1L;
    private static final LocalDateTime TEST_DATE = LocalDateTime.now();
    private static final Double TEST_PRICE = 30.00;

    @Autowired
    private ProductPriceMapper productPriceMapper;

    @Test
    void when_fromEntityToApiDto_thenReturn_ProductPriceInfo() {
        var result = productPriceMapper.fromEntityToApiDto(getProductPriceEntity());
        Assertions.assertAll(
                () -> Assertions.assertNotNull(result),
                () -> Assertions.assertEquals(BigDecimal.ONE, result.getProductId()),
                () -> Assertions.assertEquals(BigDecimal.ONE, result.getBrandId()),
                () -> Assertions.assertEquals(BigDecimal.ONE, result.getFee()),
                () -> Assertions.assertEquals(TEST_PRICE, result.getPrice())
        );
    }

    @Test
    void when_fromLocalDateToOffSetDateTime_thenReturn_offSetDateTime() {
        var offSetDateTime = productPriceMapper.fromLocalDateToOffSetDateTime(TEST_DATE);
        Assertions.assertAll(
                () -> Assertions.assertNotNull(offSetDateTime),
                () -> Assertions.assertEquals(TEST_DATE, offSetDateTime.toLocalDateTime())
        );
    }

    private ProductPriceEntity getProductPriceEntity() {
        var entity = new ProductPriceEntity();
        var productEntity = new ProductEntity(TEST_ID, "test");
        entity.setProduct(productEntity);
        var brandEntity = new BrandEntity(TEST_ID, "test");
        entity.setBrand(brandEntity);
        entity.setFee(TEST_ID);
        entity.setPrice(TEST_PRICE);
        entity.setStartDate(TEST_DATE);
        entity.setEndDate(TEST_DATE);
        return entity;
    }

}
