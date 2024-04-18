package org.yusuf.eticaret.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketProductDto {

    private long id;
    private int count;
    private double totalPrice;

    private long productId;

    private long basketId;

    public BasketProductDto (long productId,int count){
        this.productId=productId;
        this.count=count;
    }

}
