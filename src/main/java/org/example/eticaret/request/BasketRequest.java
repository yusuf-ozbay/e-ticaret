package org.example.eticaret.request;

import lombok.*;
import org.example.eticaret.dto.BasketItemDto;
import org.example.eticaret.dto.CustomerDto;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketRequest {


    private Long customerId;
    private Long productId;
    private int count;


}
