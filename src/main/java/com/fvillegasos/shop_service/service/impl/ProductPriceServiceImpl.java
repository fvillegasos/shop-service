package com.fvillegasos.shop_service.service.impl;

import com.fvillegasos.shop_service.exception.CustomErrorTypeEnum;
import com.fvillegasos.shop_service.exception.CustomHttpException;
import com.fvillegasos.shop_service.mapper.ProductPriceMapper;
import com.fvillegasos.shop_service.repository.ProductPriceRepository;
import com.fvillegasos.shop_service.service.ProductPriceService;
import com.fvillegasos.shopservice.model.ProductPriceInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    private final ProductPriceRepository repository;
    private final ProductPriceMapper mapper;

    public ProductPriceServiceImpl(ProductPriceRepository repository, ProductPriceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ProductPriceInfo getProductPriceInfo(BigDecimal productId, BigDecimal brandId, OffsetDateTime applicationDate) {
        var optProductPrice = repository.findPriorityProductPriceByFilters(productId.longValue(),
                brandId.longValue(), applicationDate.toLocalDateTime());

        if (optProductPrice.isEmpty()) {
            throw CustomHttpException.of(CustomErrorTypeEnum.NOT_FOUND_PRODUCT_PRICE);
        }

        return mapper.fromEntityToApiDto(optProductPrice.get());
    }
}
