package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.ProductDto;
import org.yusuf.eticaret.entity.Category;
import org.yusuf.eticaret.entity.Product;
import org.yusuf.eticaret.repository.ProductRepository;
import org.yusuf.eticaret.service.mapper.ProdactMapper;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryService categoryService;

    public Product findById(long id){
        Product product=productRepository.findById(id).get();

        return product;

    }

    public ProductDto save(ProductDto productDto) {
        Product product = ProdactMapper.toEntity(productDto);
        product = productRepository.save(product);
        return ProdactMapper.toDto(product);
    }



}
