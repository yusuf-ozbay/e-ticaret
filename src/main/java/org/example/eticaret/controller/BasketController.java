package org.example.eticaret.controller;


import lombok.RequiredArgsConstructor;
import org.example.eticaret.dto.BasketDto;
import org.example.eticaret.request.BasketRequest;
import org.example.eticaret.response.BasketResponse;
import org.example.eticaret.service.BasketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("baskets")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

        @PostMapping
        public BasketResponse addProductToBasket(@RequestBody BasketRequest basketRequest){
            return toResponse(basketService.addProductToBasket(basketRequest.toDto()));
        }

        @GetMapping("/{customerId}")
        public BasketResponse getBasketByCustomerId(@PathVariable String customerId){
            return toResponse(basketService.getBasketByCustomerId(customerId));
        }

        @DeleteMapping("/{basketItemId}")
        public String delete(@PathVariable String basketItemId){
            basketService.removeProductFromBasket(basketItemId);
            return "Silme işlemi başarılı";
        }

    public BasketResponse toResponse(BasketDto basketDto) {
        return BasketResponse.builder()
                .basketId(basketDto.getBasketId())
                .totalPrice(basketDto.getTotalPrice())
                .customerId(basketDto.getCustomer().getCustomerId())
                .basketItemDtoList(basketDto.getBasketItemList())
                .build();
    }
}
