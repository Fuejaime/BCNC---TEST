package com.example.starwars.contract.rest.controller;

import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.usecase.PriceUseCase;
import com.example.starwars.exception.GlobalExceptionHandler;
import com.example.starwars.model.PriceGet200Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @InjectMocks
    private PriceController underTest;

    @Mock
    private PriceUseCase priceUseCase;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(underTest)
                .setControllerAdvice(new GlobalExceptionHandler())  // Si tienes un controller advice global
                .build();
    }

    @Test
    void testPriceGet() {
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

    @Test
    void testPriceGetThrowsPriceNotFoundExceptionDomain() throws Exception {
        // Arrange
        LocalDateTime now = LocalDateTime.now();
        RequestPrice requestPrice = getRequestPrice(now);

        when(priceUseCase.getPrice(requestPrice)).thenThrow(new PriceNotFoundExceptionDomain("Price not found"));

        // Act & Assert: Verify that a 404 response is returned when exception is thrown
        mockMvc.perform(get("/price")  // Aquí especificamos el endpoint correcto
                        .param("applicationDate", now.toString())  // Pasamos el parámetro de la fecha
                        .param("productId", "1")  // Pasamos el parámetro del productId
                        .param("brandId", "1"))  // Pasamos el parámetro del brandId
                .andExpect(status().isNotFound());

        // Verify that the exception was triggered and the method was called
        verify(priceUseCase).getPrice(requestPrice);
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
