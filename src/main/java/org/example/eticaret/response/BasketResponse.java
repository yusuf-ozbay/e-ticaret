package org.example.eticaret.response;

import lombok.*;
import org.example.eticaret.dto.BasketItemDto;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse {
    private Long basketId;
    private double totalPrice;
    private int status;
    private Long customerId;
    private List<BasketItemDto> basketItemDtoList;
}
