package org.yusuf.eticaret.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BasketRequest {
    private long userId;
    private long productId;
    private int count;



}
