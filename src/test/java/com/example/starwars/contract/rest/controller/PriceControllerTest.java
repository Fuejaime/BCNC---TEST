package com.example.starwars.contract.rest.controller;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.usecase.PriceUseCase;
import com.example.starwars.model.PriceGet200Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    private PriceController underTest;

    @Mock
    private PriceUseCase priceUseCase;

    @Test
    public void testPriceGet() {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        Price price = getPrice(now);
        RequestPrice requestPrice = getRequestPrice(now);

        when(priceUseCase.getPrice(requestPrice)).thenReturn(price);

        // Act
        PriceGet200Response response = underTest.priceGet(now.toString(), 1, 1).getBody();

        // Assert
        assertNotNull(response);
        assertEquals(123.45, response.getPrice());
        assertEquals(1, response.getBrandId());
        assertEquals("USD", response.getCurrency());
        assertEquals(1, response.getPriceList());
        assertEquals(1, response.getPriority());
        assertEquals(1, response.getProductId());
        assertEquals(now.atOffset(ZoneOffset.UTC), response.getStartDate());
        assertEquals(now.plusDays(1).atOffset(ZoneOffset.UTC), response.getEndDate());
    }

    private static RequestPrice getRequestPrice(LocalDateTime now) {
        RequestPrice requestPrice = new RequestPrice();
        requestPrice.setBrandId(1);
        requestPrice.setProductId(1);
        requestPrice.setApplicationDate(String.valueOf(now));
        return requestPrice;
    }

    private static Price getPrice(LocalDateTime now) {
        Price price = new Price();
        price.setPrice(BigDecimal.valueOf(123.45));
        price.setBrandId(1);
        price.setCurrency("USD");
        price.setPriceList(1);
        price.setPriority(1);
        price.setProductId(1);
        price.setStartDate(now);
        price.setEndDate(now.plusDays(1));
        return price;
    }
}
