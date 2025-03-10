package com.example.starwars.application.usecase;

import com.example.starwars.domain.exception.PriceNotFoundExceptionDomain;
import com.example.starwars.domain.model.Price;
import com.example.starwars.domain.model.RequestPrice;
import com.example.starwars.domain.repository.GetPriceRepository;
import com.example.starwars.domain.usecase.PriceUseCase;
import com.example.starwars.infrastructure.exception.PriceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PriceUseCaseImpl implements PriceUseCase {

    private final GetPriceRepository getPriceRepository;

    public PriceUseCaseImpl(GetPriceRepository getPriceRepository) {
        this.getPriceRepository = getPriceRepository;
    }

    @Override
    public Price getPrice(RequestPrice requestPrice) {
        try {
            return getPriceRepository.getPrice(requestPrice);
        } catch (PriceNotFoundException e) {
            throw new PriceNotFoundExceptionDomain("No prices found for the given request");
        }
        }

}
