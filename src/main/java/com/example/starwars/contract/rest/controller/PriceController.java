package com.example.starwars.contract.rest.controller;

import com.example.starwars.api.PriceApi;
import com.example.starwars.application.usecase.PriceMapper;
import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.usecase.PriceUseCase;
import com.example.starwars.model.PriceGet200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController implements PriceApi {

    private final PriceUseCase priceUseCase;


    public PriceController(PriceUseCase priceUseCase) {
        this.priceUseCase = priceUseCase;
    }

    public ResponseEntity<PriceGet200Response> priceGet(String applicationDate, Integer productId, Integer brandId) {
        try {
            return ResponseEntity.ok(PriceMapper.INSTANCE.priceToPriceGet200Response(getPrice(applicationDate, productId, brandId)));

        } catch (PriceNotFoundExceptionDomain e) {
            return ResponseEntity.notFound().build();
        }
    }

    private Price getPrice(String applicationDate, Integer productId, Integer brandId) {
       return priceUseCase.getPrice(RequestPrice.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId)
                .build());
    }
}
