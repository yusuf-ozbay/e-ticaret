package org.example.eticaret.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class BasketItemDto {
    private int basketItemId;
    private double basketItemAmount;
    private int count;
    private final ProductDto product;
}
