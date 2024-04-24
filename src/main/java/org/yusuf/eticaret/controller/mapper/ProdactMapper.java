package org.yusuf.eticaret.controller.mapper;

import org.yusuf.eticaret.dto.ProductDto;
import org.yusuf.eticaret.request.ProductRequest;
import org.yusuf.eticaret.response.ProductResponse;

public class ProdactMapper {

    public static ProductDto toDto(ProductRequest productRequest){
        ProductDto productDto =new ProductDto();
        productDto.setName(productRequest.getName());
        productDto.setDescription(productRequest.getDescription());
        productDto.setPrice(productRequest.getPrice());
        productDto.setCategoryId(productRequest.getCategoryId());

        return productDto;
    }

    public static ProductResponse toResponse(ProductDto productDto){

        ProductResponse productResponse =new ProductResponse();
        productResponse.setId(productDto.getId());
        productResponse.setName(productDto.getName());
        productResponse.setDescription(productDto.getDescription());
        productResponse.setPrice(productDto.getPrice());
        productResponse.setCategoryId(productDto.getCategoryId());
        return productResponse;

    }
}
