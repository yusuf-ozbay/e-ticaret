package org.yusuf.eticaret.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.controller.mapper.ProdactMapper;
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
        return ProdactMapper.toResponse(productService.save(ProdactMapper.toDto(productRequest))) ;
    }

}
