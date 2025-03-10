package com.example.starwars.domain.usecase;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;

public interface PriceUseCase {
    Price getPrice(RequestPrice requestPrice);
}
