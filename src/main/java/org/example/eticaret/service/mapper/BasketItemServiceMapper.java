package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.BasketItemDto;
import org.example.eticaret.entity.BasketItem;

public class BasketItemServiceMapper {
    public static BasketItemDto toDto(BasketItem basketItem) {
        return BasketItemDto.builder()
                .basketItemId(basketItem.getBasketItemId())
                .basketItemAmount(basketItem.getBasketItemTotalPrice())
                .count(basketItem.getCount())
                .product(ProductServiceMapper.toDto(basketItem.getProduct()))
                .build();
    }
}
