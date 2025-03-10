package com.example.starwars.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PriceTest {

    @Test
    public void testPriceBuilder() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Price price = Price.builder()
                .brandId(1)
                .startDate(now)
                .endDate(now.plusDays(1))
                .priceList(1)
                .productId(1)
                .priority(1)
                .price(BigDecimal.valueOf(123.45))
                .currency("USD")
                .build();

        // Act & Assert
        assertThat(price).isNotNull();
        assertThat(price.getBrandId()).isEqualTo(1);
        assertThat(price.getStartDate()).isEqualTo(now);
        assertThat(price.getEndDate()).isEqualTo(now.plusDays(1));
        assertThat(price.getPriceList()).isEqualTo(1);
        assertThat(price.getProductId()).isEqualTo(1);
        assertThat(price.getPriority()).isEqualTo(1);
        assertThat(price.getPrice()).isEqualTo(BigDecimal.valueOf(123.45));
        assertThat(price.getCurrency()).isEqualTo("USD");
    }

    @Test
    public void testPriceGettersAndSetters() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Price price = new Price();
        price.setBrandId(1);
        price.setStartDate(now);
        price.setEndDate(now.plusDays(1));
        price.setPriceList(1);
        price.setProductId(1);
        price.setPriority(1);
        price.setPrice(BigDecimal.valueOf(123.45));
        price.setCurrency("USD");

        // Act & Assert
        assertThat(price.getBrandId()).isEqualTo(1);
        assertThat(price.getStartDate()).isEqualTo(now);
        assertThat(price.getEndDate()).isEqualTo(now.plusDays(1));
        assertThat(price.getPriceList()).isEqualTo(1);
        assertThat(price.getProductId()).isEqualTo(1);
        assertThat(price.getPriority()).isEqualTo(1);
        assertThat(price.getPrice()).isEqualTo(BigDecimal.valueOf(123.45));
        assertThat(price.getCurrency()).isEqualTo("USD");
    }

    @Test
    public void testPriceEqualsAndHashCode() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Price price1 = Price.builder()
                .brandId(1)
                .startDate(now)
                .endDate(now.plusDays(1))
                .priceList(1)
                .productId(1)
                .priority(1)
                .price(BigDecimal.valueOf(123.45))
                .currency("USD")
                .build();

        Price price2 = Price.builder()
                .brandId(1)
                .startDate(now)
                .endDate(now.plusDays(1))
                .priceList(1)
                .productId(1)
                .priority(1)
                .price(BigDecimal.valueOf(123.45))
                .currency("USD")
                .build();

        // Act & Assert
        assertThat(price1).isEqualTo(price2);
        assertThat(price1.hashCode()).isEqualTo(price2.hashCode());
    }

    @Test
    public void testPriceToString() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Price price = Price.builder()
                .brandId(1)
                .startDate(now)
                .endDate(now.plusDays(1))
                .priceList(1)
                .productId(1)
                .priority(1)
                .price(BigDecimal.valueOf(123.45))
                .currency("USD")
                .build();

        // Act & Assert
        assertThat(price.toString()).contains("brandId=1");
        assertThat(price.toString()).contains("startDate=" + now.toString());
        assertThat(price.toString()).contains("endDate=" + now.plusDays(1).toString());
        assertThat(price.toString()).contains("priceList=1");
        assertThat(price.toString()).contains("productId=1");
        assertThat(price.toString()).contains("priority=1");
        assertThat(price.toString()).contains("price=123.45");
        assertThat(price.toString()).contains("currency=USD");
    }

}
