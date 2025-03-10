package com.example.starwars.infrastructure.repository.impl;

import com.example.starwars.infrastructure.entity.PriceEntity;
import com.example.starwars.infrastructure.entity.RequestEntity;
import com.example.starwars.infrastructure.exception.PriceNotFoundException;
import com.example.starwars.infrastructure.repository.FindApplicablePrice;
import com.example.starwars.infrastructure.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Component
public class FindApplicablePriceImpl implements FindApplicablePrice {

    private final PriceRepository priceRepository;

    public FindApplicablePriceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceEntity findApplicablePrice(RequestEntity requestEntityEntity) {

        List<PriceEntity> results = getPriceEntities(requestEntityEntity);
        return results.stream()
                .max((e1, e2) -> Integer.compare(e1.getPriority(), e2.getPriority()))
                .orElseThrow(() -> new PriceNotFoundException("No prices found for the given request"));
    }

    private List<PriceEntity> getPriceEntities(RequestEntity requestEntityEntity) {
        LocalDateTime localDateTime = LocalDateTime.parse(requestEntityEntity.getApplicationDate());
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.UTC);
        return priceRepository.findByProductIdAndBrandIdAndDate(
                requestEntityEntity.getProductId(),
                requestEntityEntity.getBrandId(),
                offsetDateTime
        );
    }
}
