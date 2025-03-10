package com.example.starwars.application.usecase;

import com.example.starwars.domain.model.Price;
import com.example.starwars.model.PriceGet200Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

    @Mapping(source = "price", target = "price")
    @Mapping(source = "brandId", target = "brandId")
    @Mapping(source = "currency", target = "currency")
    @Mapping(source = "priceList", target = "priceList")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "startDate", target = "startDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    @Mapping(source = "endDate", target = "endDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    PriceGet200Response priceToPriceGet200Response(Price price);

    @Named("localDateTimeToOffsetDateTime")
    default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atOffset(ZoneOffset.UTC) : null;
    }

    @Named("offsetDateTimeToLocalDateTime")
    default LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime != null ? offsetDateTime.toLocalDateTime() : null;
    }
}
