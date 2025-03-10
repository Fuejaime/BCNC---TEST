package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.infrastructure.entity.PriceEntity;
import com.example.starwars.infrastructure.entity.RequestEntity;
import com.example.starwars.infrastructure.repository.FindApplicablePrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetPriceAdapterTest {

    @Mock
    private FindApplicablePrice findApplicablePrice;

    @InjectMocks
    private GetPriceAdapter underTest;

    @Test
    public void testGetPrice() {
        // Arrange
        RequestPrice requestPrice = getRequestPrice();
        PriceEntity priceEntity = getPriceEntity();

        when(findApplicablePrice.findApplicablePrice(RequestEntity.builder()
                .productId(requestPrice.getProductId())
                .brandId(requestPrice.getBrandId())
                .applicationDate(requestPrice.getApplicationDate())
                .build())).thenReturn(priceEntity);

        // Act
        Price result = underTest.getPrice(requestPrice);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getPriceList()).isEqualTo(1);
        assertThat(result.getStartDate()).isEqualTo(LocalDateTime.of(2023, 8, 15, 10, 0));
        assertThat(result.getEndDate()).isEqualTo(LocalDateTime.of(2023, 8, 16, 10, 0));
        assertThat(result.getProductId()).isEqualTo(1);
        assertThat(result.getBrandId()).isEqualTo(1);
        assertThat(result.getPrice()).isEqualTo(BigDecimal.valueOf(99.99));
        assertThat(result.getCurrency()).isEqualTo("USD");
        assertThat(result.getPriority()).isEqualTo(1);
    }

    private static RequestPrice getRequestPrice() {
        return RequestPrice.builder()
                .productId(1)
                .brandId(1)
                .applicationDate("2023-08-15T10:00:00")
                .build();
    }

    private static PriceEntity getPriceEntity() {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(1L);
        priceEntity.setBrandId(1);
        priceEntity.setStartDate(OffsetDateTime.of(LocalDateTime.of(2023, 8, 15, 10, 0), OffsetDateTime.now().getOffset()));
        priceEntity.setEndDate(OffsetDateTime.of(LocalDateTime.of(2023, 8, 16, 10, 0), OffsetDateTime.now().getOffset()));
        priceEntity.setPriceList(1);
        priceEntity.setProductId(1);
        priceEntity.setPriority(1);
        priceEntity.setPrice(BigDecimal.valueOf(99.99));
        priceEntity.setCurrency("USD");

        return priceEntity;
    }
}
