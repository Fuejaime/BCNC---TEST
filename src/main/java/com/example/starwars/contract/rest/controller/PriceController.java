package com.example.starwars.contract.rest.controller;

import com.example.starwars.api.PriceApi;
import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.usecase.PriceUseCase;
import com.example.starwars.model.PriceGet200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneOffset;

@RestController
public class PriceController implements PriceApi {

    private final PriceUseCase priceUseCase;


    public PriceController(PriceUseCase priceUseCase) {
        this.priceUseCase = priceUseCase;
    }

    @Override
    public ResponseEntity<PriceGet200Response> priceGet(String applicationDate, Integer productId, Integer brandId) {
        try {
            return ResponseEntity.ok(getPriceGet200Response(getPrice(applicationDate, productId, brandId)));
        } catch (PriceNotFoundExceptionDomain e) {
            return ResponseEntity.notFound().build();
        }
        }

    private static PriceGet200Response getPriceGet200Response(Price price) {
        PriceGet200Response priceGet200Response = new PriceGet200Response();
        priceGet200Response.setPrice(price.getPrice().doubleValue());
        priceGet200Response.setBrandId(price.getBrandId());
        priceGet200Response.setCurrency(price.getCurrency());
        priceGet200Response.setPriceList(price.getPriceList());
        priceGet200Response.setPriority(price.getPriority());
        priceGet200Response.setProductId(price.getProductId());
        priceGet200Response.setStartDate(price.getStartDate().atOffset(ZoneOffset.UTC));
        priceGet200Response.setEndDate((price.getEndDate().atOffset(ZoneOffset.UTC)));
        return priceGet200Response;
    }

    private Price getPrice(String applicationDate, Integer productId, Integer brandId) {
       return priceUseCase.getPrice(RequestPrice.builder()
                .applicationDate(applicationDate)
                .productId(productId)
                .brandId(brandId)
                .build());

    }

}
