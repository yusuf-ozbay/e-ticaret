package org.example.eticaret.dto;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {

    private Long basketId;
    private double totalPrice;
    private int status;
    private CustomerDto customerDto;
    private List<BasketItemDto> basketItemDtoList;
}
