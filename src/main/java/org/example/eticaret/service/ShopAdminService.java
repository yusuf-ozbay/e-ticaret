package org.example.eticaret.service;

import org.example.eticaret.dto.ProductDto;
import org.example.eticaret.dto.ShopAdminDto;

import java.util.List;

public interface ShopAdminService {

    ShopAdminDto save(ShopAdminDto shopAdminDto);

    ShopAdminDto getShopAdmin(Long id);

    List<ShopAdminDto> getAllShopAdmin();

    ShopAdminDto update(ShopAdminDto shopAdminDto, Long id);

    void delete(Long id);

    ProductDto addProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();
}
