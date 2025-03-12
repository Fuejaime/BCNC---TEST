package com.example.starwars.contract.rest.controller.integration.controller;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.usecase.PriceUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIT {

    @Autowired
    private MockMvc mockMvc;  // MockMvc automático

    @Autowired
    private PriceUseCase priceUseCase;  // Se inyecta automáticamente el PriceUseCase

    @BeforeEach
    public void setUp() {
        // Configuración previa, si es necesario
    }

    @Test
    void testPriceGetIntegration() throws Exception {

        mockMvc.perform(get("/price")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "1"))
                .andExpect(status().isOk())  // Verifica que la respuesta sea 200 OK
                .andExpect(jsonPath("$.price").value(35.5))
                .andExpect(jsonPath("$.brandId").value(1))
                .andExpect(jsonPath("$.currency").value("EUR"))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.priority").value(0))
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00Z"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59Z"));
    }
}
