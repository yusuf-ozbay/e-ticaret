package org.example.eticaret.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.entity.BasketItem;
import org.example.eticaret.repository.BasketItemRepository;
import org.example.eticaret.service.BasketItemService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketItemServiceImpl implements BasketItemService {
    private final BasketItemRepository repository;
    private final ProductServiceImpl productService;


    @Override
    public BasketItem findBasketItemByBasketIdAndProductId(int basketId, int productId) {
        return null;
    }

    @Override
    public BasketItem save(BasketItem basketItem) {
        return null;
    }

    @Override
    public void delete(int basketItemId) {

    }
}
