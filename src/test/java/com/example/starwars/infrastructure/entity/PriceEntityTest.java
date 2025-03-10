package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PriceEntityTest {
    @Test
    public void testPriceEntityGettersAndSetters() {
        // Arrange
        Result result = getResult();

        // Act
        PriceEntity priceEntity = getPriceEntity(result);

        // Assert
        assertThat(priceEntity.getId()).isEqualTo(result.id());
        assertThat(priceEntity.getBrandId()).isEqualTo(result.brandId());
        assertThat(priceEntity.getStartDate()).isEqualTo(result.startDate());
        assertThat(priceEntity.getEndDate()).isEqualTo(result.endDate());
        assertThat(priceEntity.getPriceList()).isEqualTo(result.priceList());
        assertThat(priceEntity.getProductId()).isEqualTo(result.productId());
        assertThat(priceEntity.getPriority()).isEqualTo(result.priority());
        assertThat(priceEntity.getPrice()).isEqualTo(result.price());
        assertThat(priceEntity.getCurrency()).isEqualTo(result.currency());
    }



    @Test
    public void testPriceEntityConstructorWithArgs() {
        // Arrange
        Result result = getResult();

        // Act
        PriceEntity priceEntity = getPriceEntity(result);

        // Assert
        assertThat(priceEntity.getId()).isEqualTo(result.id());
        assertThat(priceEntity.getBrandId()).isEqualTo(result.brandId());
        assertThat(priceEntity.getStartDate()).isEqualTo(result.startDate());
        assertThat(priceEntity.getEndDate()).isEqualTo(result.endDate());
        assertThat(priceEntity.getPriceList()).isEqualTo(result.priceList());
        assertThat(priceEntity.getProductId()).isEqualTo(result.productId());
        assertThat(priceEntity.getPriority()).isEqualTo(result.priority());
        assertThat(priceEntity.getPrice()).isEqualTo(result.price());
        assertThat(priceEntity.getCurrency()).isEqualTo(result.currency());
    }

    private static PriceEntity getPriceEntity(Result result) {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(result.id());
        priceEntity.setBrandId(result.brandId());
        priceEntity.setStartDate(result.startDate());
        priceEntity.setEndDate(result.endDate());
        priceEntity.setPriceList(result.priceList());
        priceEntity.setProductId(result.productId());
        priceEntity.setPriority(result.priority());
        priceEntity.setPrice(result.price());
        priceEntity.setCurrency(result.currency());
        return priceEntity;
    }

    private static Result getResult() {
        Long id = 1L;
        int brandId = 1;
        OffsetDateTime startDate = OffsetDateTime.now();
        OffsetDateTime endDate = OffsetDateTime.now().plusDays(1);
        int priceList = 1;
        int productId = 1;
        int priority = 1;
        BigDecimal price = BigDecimal.valueOf(99.99);
        String currency = "USD";
        return new Result(id, brandId, startDate, endDate, priceList, productId, priority, price, currency);
    }

    private record Result(Long id, int brandId, OffsetDateTime startDate, OffsetDateTime endDate, int priceList, int productId, int priority, BigDecimal price, String currency) {
    }

}
