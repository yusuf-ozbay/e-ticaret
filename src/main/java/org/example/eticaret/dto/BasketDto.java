package org.example.eticaret.dto;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {

    private int basketId;
    private double totalPrice;
    private int status;
    private CustomerDto customer;
    private List<BasketItemDto> basketItemList;
}
