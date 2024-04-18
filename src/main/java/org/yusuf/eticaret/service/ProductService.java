package org.yusuf.eticaret.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yusuf.eticaret.dto.ProductDto;
import org.yusuf.eticaret.entity.Category;
import org.yusuf.eticaret.entity.Product;
import org.yusuf.eticaret.repository.ProductRepository;


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
        Product product =toEntity(productDto);
        product = productRepository.save(product);
        return toDto(product);
    }

    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryService.findById(productDto.getCategoryId()));
        return product;
    }

    public ProductDto toDto(Product product){
        ProductDto productDto =new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());

        return productDto;

    }

}
