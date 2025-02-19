package org.example.eticaret.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private int id;
    private String name;
    private String description;
    private double price;
    private Long categoryId;
    private int stock;


    public ProductDto(int productId) {
        this.id = productId;
    }
}
