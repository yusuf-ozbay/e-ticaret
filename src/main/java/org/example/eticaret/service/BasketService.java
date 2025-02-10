package org.example.eticaret.service;

import org.example.eticaret.dto.BasketDto;

public interface BasketService {

    BasketDto addProductToBasket(BasketDto basketDto);
    BasketDto getBasketByCustomerId(String customerId);

    void removeProductFromBasket(String basketItemId);


}
