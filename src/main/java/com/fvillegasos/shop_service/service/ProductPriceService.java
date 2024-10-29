package com.fvillegasos.shop_service.service;


import com.fvillegasos.shopservice.model.ProductPriceInfo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface ProductPriceService {

    ProductPriceInfo getProductPriceInfo(BigDecimal productId, BigDecimal brandId, OffsetDateTime applicationDate);

}
