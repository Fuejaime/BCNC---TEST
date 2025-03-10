package com.example.starwars.domain.repository;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;

public interface GetPriceRepository {
    Price getPrice(RequestPrice requestPrice);
}
