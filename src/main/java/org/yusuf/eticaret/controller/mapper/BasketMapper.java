package org.yusuf.eticaret.controller.mapper;

import org.yusuf.eticaret.dto.BasketDto;
import org.yusuf.eticaret.dto.BasketProductDto;
import org.yusuf.eticaret.request.BasketRequest;
import org.yusuf.eticaret.response.BasketResponse;

import java.util.ArrayList;
import java.util.List;

public class BasketMapper {


    public static BasketDto toDto(BasketRequest basketRequest) {
        List<BasketProductDto> basketProductDtoList = new ArrayList<>();
        basketProductDtoList.add(new BasketProductDto(basketRequest.getProductId(), basketRequest.getCount()));
        BasketDto basketDto = new BasketDto();
        basketDto.setCount(basketRequest.getCount());
        basketDto.setUserId(basketRequest.getUserId());
        basketDto.setBasketProducts(basketProductDtoList);
        return basketDto;

    }

    public static BasketResponse toRespose(BasketDto basketDto) {
        BasketResponse basketResponse = new BasketResponse();
        basketResponse.setId(basketDto.getId());
        basketResponse.setStatus(basketDto.getStatus());
        basketResponse.setTotalPrice(basketDto.getTotalPrice());
        basketResponse.setUserId(basketDto.getUserId());
        basketResponse.setBasketProducts(basketDto.getBasketProducts());
        return basketResponse;

    }

}
