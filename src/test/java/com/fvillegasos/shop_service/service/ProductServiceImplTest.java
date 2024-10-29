package com.fvillegasos.shop_service.service;

import com.fvillegasos.shop_service.entity.ProductPriceEntity;
import com.fvillegasos.shop_service.exception.CustomHttpException;
import com.fvillegasos.shop_service.mapper.ProductPriceMapper;
import com.fvillegasos.shop_service.repository.ProductPriceRepository;
import com.fvillegasos.shop_service.service.impl.ProductPriceServiceImpl;
import com.fvillegasos.shopservice.model.ProductPriceInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Optional;

@SpringBootTest
class ProductServiceImplTest {

    @Mock
    private ProductPriceRepository productPriceRepository;
    @Mock
    private ProductPriceMapper productPriceMapper;
    @InjectMocks
    private ProductPriceServiceImpl productPriceService;

    @Test
    void when_getProductPriceInfo_thenReturn_ProductPriceInfo() {
        Mockito.when(productPriceRepository.findPriorityProductPriceByFilters(Mockito.anyLong(), Mockito.anyLong(), Mockito.any()))
                .thenReturn(Optional.of(new ProductPriceEntity()));
        Mockito.when(productPriceMapper.fromEntityToApiDto(Mockito.any()))
                .thenReturn(new ProductPriceInfo());

        var result = productPriceService.getProductPriceInfo(BigDecimal.ONE, BigDecimal.ONE, OffsetDateTime.now());

        Assertions.assertNotNull(result);
    }

    @Test
    void when_getProductPriceInfo_thenReturn_CustomHttpException_404() {
        Mockito.when(productPriceRepository.findPriorityProductPriceByFilters(Mockito.anyLong(), Mockito.anyLong(), Mockito.any()))
                .thenReturn(Optional.empty());
        try {
            productPriceService.getProductPriceInfo(BigDecimal.ONE, BigDecimal.ONE, OffsetDateTime.now());
        } catch (CustomHttpException customHttpException) {
            Assertions.assertAll(
                    () -> Assertions.assertNotNull(customHttpException),
                    () -> Assertions.assertEquals(HttpStatus.NOT_FOUND, customHttpException.getHttpStatusCode()),
                    () -> Assertions.assertNotNull(customHttpException.getMessage())
            );
        }
    }

}
