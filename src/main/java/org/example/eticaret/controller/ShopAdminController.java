package org.example.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.controller.mapper.ShopAdminControllerMapper;
import org.example.eticaret.dto.ShopAdminDto;
import org.example.eticaret.request.ShopAdminRequest;
import org.example.eticaret.response.ShopAdminResponse;
import org.example.eticaret.service.ShopAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop-admin")
public class ShopAdminController {

    private final ShopAdminService shopAdminService;

    @PostMapping("create")
    public ResponseEntity<ShopAdminResponse> createShopAdmin(@RequestBody ShopAdminRequest shopAdminRequest) {
        ShopAdminDto shopAdminDto = ShopAdminControllerMapper.toDto(shopAdminRequest);
        return ResponseEntity.ok(ShopAdminControllerMapper.toResponse(shopAdminService.save(shopAdminDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ShopAdminResponse> update(@PathVariable("id") Long shopAdminId, @RequestBody ShopAdminDto shopAdminDto) {
        ShopAdminDto updatedShopAdmin = shopAdminService.update(shopAdminDto, shopAdminId);
        return ResponseEntity.ok(ShopAdminControllerMapper.toResponse(updatedShopAdmin));
    }

    @GetMapping("{id}")
    public ResponseEntity<ShopAdminResponse> getShopAdmin(@PathVariable("id") Long id) {
        ShopAdminDto shopAdminDto = shopAdminService.getShopAdmin(id);
        return ResponseEntity.ok(ShopAdminControllerMapper.toResponse(shopAdminDto));
    }

    @GetMapping
    public ResponseEntity<List<ShopAdminResponse>> getAllShopAdmins() {
        List<ShopAdminDto> shopAdminDtoList = shopAdminService.getAllShopAdmin();
        List<ShopAdminResponse> shopAdminResponseList = shopAdminDtoList.stream()
                .map(ShopAdminControllerMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(shopAdminResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShopAdmin(@PathVariable("id") Long shopAdminId) {
        shopAdminService.delete(shopAdminId);
        return ResponseEntity.ok("ShopAdmin deleted successfully");
    }
}
