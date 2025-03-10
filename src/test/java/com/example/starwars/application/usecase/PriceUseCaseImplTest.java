package com.example.starwars.application.usecase;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.repository.GetPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceUseCaseImplTest {

      @InjectMocks
      private PriceUseCaseImpl underTest;

      @Mock
      private GetPriceRepository getPriceRepository;


      @Test
      void getPrice() {
      RequestPrice requestPrice = new RequestPrice();
      Price price = new Price();
      when(getPriceRepository.getPrice(requestPrice)).thenReturn(price);
      assertEquals(price, underTest.getPrice(requestPrice));
       }
}
