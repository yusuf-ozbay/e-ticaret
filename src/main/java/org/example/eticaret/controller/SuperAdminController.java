package org.example.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.controller.mapper.SuperAdminControllerMapper;
import org.example.eticaret.dto.SuperAdminDto;
import org.example.eticaret.request.SuperAdminRequest;
import org.example.eticaret.response.SuperAdminResponse;
import org.example.eticaret.service.SuperAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/super-admin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PostMapping("/create")
    public ResponseEntity<SuperAdminResponse> createSuperAdmin(@RequestBody SuperAdminRequest superAdminRequest) {
        SuperAdminDto superAdminDto = SuperAdminControllerMapper.toDto(superAdminRequest);
        SuperAdminDto savedSuperAdmin = superAdminService.save(superAdminDto);
        return ResponseEntity.ok(SuperAdminControllerMapper.toResponse(savedSuperAdmin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SuperAdminResponse> getSuperAdmin(@PathVariable Long id) {
        SuperAdminDto superAdminDto = superAdminService.get(id);
        return ResponseEntity.ok(SuperAdminControllerMapper.toResponse(superAdminDto));
    }

    @GetMapping
    public ResponseEntity<List<SuperAdminResponse>> getAllSuperAdmins() {
        List<SuperAdminDto> superAdminDtos = superAdminService.getAll();
        List<SuperAdminResponse> responses = superAdminDtos.stream()
                .map(SuperAdminControllerMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSuperAdmin(@PathVariable Long id) {
        superAdminService.delete(id);
        return ResponseEntity.ok("SuperAdmin deleted successfully");
    }
}
