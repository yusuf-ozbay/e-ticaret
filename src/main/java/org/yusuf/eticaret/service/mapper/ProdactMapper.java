package org.yusuf.eticaret.service.mapper;

import org.yusuf.eticaret.dto.ProductDto;
import org.yusuf.eticaret.entity.Product;
import org.yusuf.eticaret.service.CategoryService;

public class ProdactMapper {


    private static CategoryService categoryService;

    public static Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryService.findById(productDto.getCategoryId()));
        return product;
    }

    public static ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());

        return productDto;

    }
}
