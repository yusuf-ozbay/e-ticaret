package org.yusuf.eticaret.service.mapper;

import org.yusuf.eticaret.dto.BasketDto;
import org.yusuf.eticaret.dto.BasketProductDto;
import org.yusuf.eticaret.entity.Basket;
import org.yusuf.eticaret.entity.BasketProduct;

import java.util.ArrayList;
import java.util.List;

public class BasketMapper {



    public static BasketDto toDto(Basket basket) {

        List<BasketProductDto> basketProductDtos = new ArrayList<>();     //burda basket productsu veremediğim için dto listsini oluşturdum
        for (BasketProduct basketProduct : basket.getBasketProducts()) {

            BasketProductDto basketProductDto = new BasketProductDto();
            basketProductDto.setId(basketProduct.getId());
            basketProductDto.setProductId(basketProduct.getProduct().getId());
            basketProductDto.setTotalPrice(basketProduct.getTotalPrice());
            basketProductDto.setBasketId(basketProduct.getBasket().getId());
            basketProductDtos.add(basketProductDto);

        }

        BasketDto basketDto = new BasketDto();
        basketDto.setId(basket.getId());
        basketDto.setStatus(basket.getStatus());
        basketDto.setTotalPrice(basket.getTotalPrice());
        basketDto.setUserId(basket.getUser().getId());
        basketDto.setBasketProducts(basketProductDtos);

        return basketDto;
    }


}
