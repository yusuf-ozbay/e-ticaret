package org.yusuf.eticaret.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.dto.BasketDto;
import org.yusuf.eticaret.dto.BasketProductDto;
import org.yusuf.eticaret.repository.BasketRepository;
import org.yusuf.eticaret.request.BasketRequest;
import org.yusuf.eticaret.response.BasketResponse;
import org.yusuf.eticaret.service.BasketService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Baskets")
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest basketRequest){
        return toRespose(basketService.save(toDto(basketRequest) )) ;

    }

    private BasketDto toDto(BasketRequest basketRequest) {
        List<BasketProductDto> basketProductDtoList=new ArrayList<>();
        basketProductDtoList.add(new BasketProductDto(basketRequest.getProductId(),basketRequest.getCount()));
        BasketDto basketDto=new BasketDto();
        basketDto.setCount(basketRequest.getCount());
        basketDto.setUserId(basketRequest.getUserId());
        basketDto.setBasketProducts(basketProductDtoList);
        return basketDto;

    }

    private BasketResponse toRespose(BasketDto basketDto) {
        BasketResponse basketResponse=new BasketResponse();
        basketResponse.setId(basketDto.getId());
        basketResponse.setStatus(basketDto.getStatus());
        basketResponse.setTotalPrice(basketDto.getTotalPrice());
        basketResponse.setUserId(basketDto.getUserId());
        basketResponse.setBasketProducts(basketDto.getBasketProducts());
        return basketResponse;

    }


}
