package com.example.starwars.exception;

import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import com.example.starwars.infrastructure.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GlobalExceptionHandler.class)
class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PriceRepository priceRepository;

    @Test
    void testHandlePriceNotFound() throws Exception {
        // Simular una petición que cause la excepción
        mockMvc.perform(get("/some-endpoint") // Usa cualquier endpoint de tu aplicación
                        .requestAttr("exception", new PriceNotFoundExceptionDomain("Price not found")))
                .andExpect(status().isNotFound());
    }
}
