package org.example.eticaret.controller;

import lombok.RequiredArgsConstructor;
import org.example.eticaret.controller.mapper.CategoryControllerMapper;
import org.example.eticaret.dto.CategoryDto;
import org.example.eticaret.request.CategoryRequest;
import org.example.eticaret.response.CategoryResponse;
import org.example.eticaret.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryDto categoryDto = CategoryControllerMapper.toDto(categoryRequest);
        return ResponseEntity.ok(CategoryControllerMapper.toResponse(categoryService.save(categoryDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable("id") Long categoryId, @RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.update(categoryId, categoryDto);
        return ResponseEntity.ok(CategoryControllerMapper.toResponse(category));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.getCategory(id);
        return ResponseEntity.ok(CategoryControllerMapper.toResponse(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryDto> categoryDtoList = categoryService.getAll();

        List<CategoryResponse> categoryResponseList = categoryDtoList.stream()
                .map(CategoryControllerMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoryResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}



