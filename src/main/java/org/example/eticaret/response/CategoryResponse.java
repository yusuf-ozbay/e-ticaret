package org.example.eticaret.response;

import lombok.*;
import org.example.eticaret.dto.ProductDto;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
    private List<ProductDto> productDtos;

}
