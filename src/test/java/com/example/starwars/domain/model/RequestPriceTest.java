package com.example.starwars.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class RequestPriceTest {

    @Test
    public void testRequestPriceBuilder() {
        // Arrange
        RequestPrice requestPrice = RequestPrice.builder()
                .brandId(1)
                .productId(100)
                .applicationDate("2023-08-15T10:00:00")
                .build();

        // Act & Assert
        assertThat(requestPrice).isNotNull();
        assertThat(requestPrice.getBrandId()).isEqualTo(1);
        assertThat(requestPrice.getProductId()).isEqualTo(100);
        assertThat(requestPrice.getApplicationDate()).isEqualTo("2023-08-15T10:00:00");
    }

    @Test
    public void testRequestPriceGettersAndSetters() {
        // Arrange
        RequestPrice requestPrice = new RequestPrice();
        requestPrice.setBrandId(1);
        requestPrice.setProductId(100);
        requestPrice.setApplicationDate("2023-08-15T10:00:00");

        // Act & Assert
        assertThat(requestPrice.getBrandId()).isEqualTo(1);
        assertThat(requestPrice.getProductId()).isEqualTo(100);
        assertThat(requestPrice.getApplicationDate()).isEqualTo("2023-08-15T10:00:00");
    }
}
