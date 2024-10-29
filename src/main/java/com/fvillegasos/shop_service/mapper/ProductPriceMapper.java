package com.fvillegasos.shop_service.mapper;

import com.fvillegasos.shop_service.entity.ProductPriceEntity;
import com.fvillegasos.shopservice.model.ProductPriceInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface ProductPriceMapper {

    @Mapping(target = "productId", source = "product.productId")
    @Mapping(target = "brandId", source = "brand.brandId")
    ProductPriceInfo fromEntityToApiDto(ProductPriceEntity source);

    default OffsetDateTime fromLocalDateToOffSetDateTime(LocalDateTime localDateTime) {
        final ZoneId zone = ZoneId.of("Europe/Madrid");
        var zoneOffSet = zone.getRules().getOffset(localDateTime);
        return localDateTime.atOffset(zoneOffSet);
    }
}
