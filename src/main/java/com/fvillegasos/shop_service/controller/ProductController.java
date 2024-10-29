package com.fvillegasos.shop_service.controller;

import com.fvillegasos.shop_service.service.ProductPriceService;
import com.fvillegasos.shopservice.api.ProductApi;
import com.fvillegasos.shopservice.model.ProductPriceInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@RestController
public class ProductController implements ProductApi {

    private final ProductPriceService productPriceService;

    public ProductController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @Override
    public ResponseEntity<ProductPriceInfo> getProductPrice(BigDecimal productId, OffsetDateTime applicationDate, BigDecimal brandId) {
        return ResponseEntity.ok(productPriceService.getProductPriceInfo(productId, brandId, applicationDate));
    }
}
