package org.example.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.controller.mapper.ProductControllerMapper;
import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.request.ProductRequest;
import org.example.eticaret.response.ProductResponse;
import org.example.eticaret.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductDto productDto = ProductControllerMapper.toDto(productRequest);
        return ResponseEntity.ok(ProductControllerMapper.toResponse(productService.save(productDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        ProductDto updatedProduct = productService.update(id, productDto);
        return ResponseEntity.ok(ProductControllerMapper.toResponse(updatedProduct));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") int id) {
        ProductDto productDto = productService.getProduct(id);
        return ResponseEntity.ok(ProductControllerMapper.toResponse(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductDto> productDtoList = productService.getAll();
        List<ProductResponse> productResponseList = productDtoList.stream()
                .map(ProductControllerMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(productResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
