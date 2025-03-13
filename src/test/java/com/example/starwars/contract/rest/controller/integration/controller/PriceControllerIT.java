package com.example.starwars.contract.rest.controller.integration.controller;

import com.example.starwars.domain.usecase.PriceUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceUseCase priceUseCase;

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

    @Test
    void testException() throws Exception {

        mockMvc.perform(get("/price")
                        .param("applicationDate", "2020-06-15T10:00:00")
                        .param("productId", "35455")
                        .param("brandId", "2"))
                .andExpect(status().isNotFound());  // Verifica que la respuesta sea 404 Not Found
    }
}
