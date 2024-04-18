package org.yusuf.eticaret.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yusuf.eticaret.dto.BasketProductDto;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketResponse {
    private Long id;
    private int status;
    private double totalPrice;

    private long UserId;

    private List<BasketProductDto> basketProducts;
}
