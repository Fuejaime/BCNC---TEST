package com.example.starwars.infrastructure.repository;

import com.example.starwars.infrastructure.entity.PriceEntity;
import com.example.starwars.infrastructure.entity.RequestEntity;

public interface FindApplicablePrice {
    PriceEntity findApplicablePrice(RequestEntity requestEntity);
}
