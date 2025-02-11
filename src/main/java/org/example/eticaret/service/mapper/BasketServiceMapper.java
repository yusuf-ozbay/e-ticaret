package org.example.eticaret.service.mapper;

import org.example.eticaret.dto.BasketDto;
import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.entity.Basket;
import org.example.eticaret.entity.Product;
import org.example.eticaret.service.CategoryService;

import java.util.stream.Collectors;

public class BasketServiceMapper {

    public static Product toEntity( CategoryService categoryService ,ProductDto productDto) {
        return Product.builder()
                .productId(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(categoryService.getEntity(productDto.getCategoryId()))
                .stock(productDto.getStock())
                .build();
    }

    public static BasketDto toDto(Basket basket){

        return BasketDto.builder()
                .basketId(basket.getBasketId())
                .totalPrice(basket.getTotalPrice())
                .status(basket.getStatus())
                .customer(CustomerServiceMapper.toDto(basket.getCustomer()))
                .basketItemList(basket.getBasketItemList()
                        .stream()
                        .map(basketItem -> BasketItemServiceMapper.toDto(basketItem))
                        .collect(Collectors.toList())
                )
                .build();
    }

}
