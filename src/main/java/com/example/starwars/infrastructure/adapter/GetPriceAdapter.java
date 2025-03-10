package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.repository.GetPriceRepository;
import com.example.starwars.infrastructure.entity.PriceEntity;
import com.example.starwars.infrastructure.entity.RequestEntity;
import com.example.starwars.infrastructure.repository.FindApplicablePrice;
import org.springframework.stereotype.Component;

@Component
public class GetPriceAdapter implements GetPriceRepository {

    private final FindApplicablePrice findApplicablePrice;

    public GetPriceAdapter( FindApplicablePrice findApplicablePrice) {
        this.findApplicablePrice = findApplicablePrice;
    }


    @Override
    public Price getPrice(RequestPrice requestPrice) {
        PriceEntity priceEntity = getPriceEntity(requestPrice);
        return Price.builder()
                .priceList(priceEntity.getPriceList())
                .startDate(priceEntity.getStartDate().toLocalDateTime())
                .endDate(priceEntity.getEndDate().toLocalDateTime())
                .productId(priceEntity.getProductId())
                .brandId(priceEntity.getBrandId())
                .price(priceEntity.getPrice())
                .currency(priceEntity.getCurrency())
                .priority(priceEntity.getPriority())
                .build();
    }

    private PriceEntity getPriceEntity(RequestPrice requestPrice) {
        return findApplicablePrice.findApplicablePrice(RequestEntity.builder()
                .productId(requestPrice.getProductId())
                .brandId(requestPrice.getBrandId())
                .applicationDate(requestPrice.getApplicationDate())
                .build());
    }
}
