package org.example.eticaret.service;

import org.example.eticaret.entity.BasketItem;

public interface BasketItemService {
    BasketItem findBasketItemByBasketIdAndProductId(int basketId, int productId);
    BasketItem save(BasketItem basketItem);

    void delete(int basketItemId);

}
