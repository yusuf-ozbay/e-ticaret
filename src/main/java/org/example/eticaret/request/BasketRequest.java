package org.example.eticaret.request;

import lombok.*;
import org.example.eticaret.dto.BasketDto;
import org.example.eticaret.dto.BasketItemDto;
import org.example.eticaret.dto.CustomerDto;
import org.example.eticaret.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class BasketRequest {


    private int customerId;
    private int productId;
    private int count;


    public BasketDto toDto(){
        List<BasketItemDto> dtoList = new ArrayList<>();
        BasketItemDto dto = BasketItemDto.builder().
                product(new ProductDto(productId)).
                build();
        dto.setCount(count);
        dtoList.add(dto);
        return BasketDto.builder()
                .customer(CustomerDto.builder().customerId(customerId).build())
                .basketItemList(dtoList)
                .build();
    }
}
