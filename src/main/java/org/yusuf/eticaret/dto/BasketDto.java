package org.yusuf.eticaret.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yusuf.eticaret.entity.BasketProduct;
import org.yusuf.eticaret.entity.User;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {
    private Long id;
    private int status;
    private double totalPrice;

    private long UserId;

    private List<BasketProductDto> basketProducts;
    private int count;

}
