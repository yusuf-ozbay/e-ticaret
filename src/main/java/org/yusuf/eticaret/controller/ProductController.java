package org.yusuf.eticaret.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.dto.ProductDto;
import org.yusuf.eticaret.request.ProductRequest;
import org.yusuf.eticaret.response.ProductResponse;
import org.yusuf.eticaret.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ProductResponse save (@RequestBody ProductRequest productRequest){
        return toResponse(productService.save(toDto(productRequest))) ;
    }

    public ProductDto toDto(ProductRequest productRequest){
        ProductDto productDto =new ProductDto();
        productDto.setName(productRequest.getName());
        productDto.setDescription(productRequest.getDescription());
        productDto.setPrice(productRequest.getPrice());
        productDto.setCategoryId(productRequest.getCategoryId());

        return productDto;
    }

    public ProductResponse toResponse(ProductDto productDto){

        ProductResponse productResponse =new ProductResponse();
        productResponse.setId(productDto.getId());
        productResponse.setName(productDto.getName());
        productResponse.setDescription(productDto.getDescription());
        productResponse.setPrice(productDto.getPrice());
        productResponse.setCategoryId(productDto.getCategoryId());
        return productResponse;

    }

}
