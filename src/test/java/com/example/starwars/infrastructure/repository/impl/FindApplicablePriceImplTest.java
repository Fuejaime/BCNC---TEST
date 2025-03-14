package com.example.starwars.infrastructure.repository.impl;

import com.example.starwars.infrastructure.entity.PriceEntity;
import com.example.starwars.infrastructure.entity.RequestEntity;
import com.example.starwars.infrastructure.exception.PriceNotFoundException;
import com.example.starwars.infrastructure.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindApplicablePriceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private FindApplicablePriceImpl underTest;

    @Test
    void testFindApplicablePriceReturnsHighestPriority() {
        // Arrange
        RequestEntity requestEntity = getRequestEntity();
        List<PriceEntity> priceEntities = List.of(getEntity());
        OffsetDateTime applicationDate = OffsetDateTime.parse("2024-08-15T10:00:00Z");

        when(priceRepository.findByProductIdAndBrandIdAndDate(requestEntity.getProductId(), (long) requestEntity.getBrandId(), applicationDate))
                .thenReturn(priceEntities);

        // Act
        PriceEntity result = underTest.findApplicablePrice(requestEntity);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getPriority()).isEqualTo(2);  // Highest priority
        assertThat(result.getPrice()).isEqualByComparingTo("60.00");

        verify(priceRepository).findByProductIdAndBrandIdAndDate(requestEntity.getProductId(), (long) requestEntity.getBrandId(), applicationDate);
    }

    @Test
    void testFindApplicablePriceReturnsNullIfNoPricesFound() {
        // Arrange
        RequestEntity requestEntity = getRequestEntity();

        OffsetDateTime applicationDate = OffsetDateTime.parse("2024-08-15T10:00:00Z");

        when(priceRepository.findByProductIdAndBrandIdAndDate(requestEntity.getProductId(), (long) requestEntity.getBrandId(), applicationDate))
                .thenReturn(Collections.emptyList());

        // Act & Assert
        assertThrows(PriceNotFoundException.class, () -> {
            underTest.findApplicablePrice(requestEntity);
        });
    }

    private static PriceEntity getEntity() {
        PriceEntity highPriorityPrice = new PriceEntity();
        highPriorityPrice.setPriority(2);
        highPriorityPrice.setPrice(new BigDecimal("60.00"));
        return highPriorityPrice;
    }

    private static RequestEntity getRequestEntity() {
        return RequestEntity.builder()
                .brandId(1)
                .productId(12345)
                .applicationDate("2024-08-15T10:00:00")
                .build();
    }
}