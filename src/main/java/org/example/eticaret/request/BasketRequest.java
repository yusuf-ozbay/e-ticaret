package org.example.eticaret.request;

import lombok.*;
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
