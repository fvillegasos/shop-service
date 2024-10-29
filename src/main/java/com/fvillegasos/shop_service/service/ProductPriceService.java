package com.prueba.zara.fvillegasos.PruebaTecnicaZara.service;

import com.prueba.zara.fvillegasos.PruebaTecnicaZara.model.ProductPriceInfo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public interface ProductPriceService {

    ProductPriceInfo getProductPriceInfo(BigDecimal productId, BigDecimal brandId, OffsetDateTime applicationDate);

}
