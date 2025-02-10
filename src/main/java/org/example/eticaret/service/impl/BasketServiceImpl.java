package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.BasketDto;
import org.example.eticaret.repository.BasketRepository;
import org.example.eticaret.service.BasketService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
     private final BasketRepository basketRepository;


    @Override
    public BasketDto addProductToBasket(BasketDto basketDto) {
        return null;
    }

    @Override
    public BasketDto getBasketByCustomerId(String customerId) {
        return null;
    }

    @Override
    public void removeProductFromBasket(String basketItemId) {

    }
}
