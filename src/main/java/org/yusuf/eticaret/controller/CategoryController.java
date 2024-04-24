package org.yusuf.eticaret.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yusuf.eticaret.controller.mapper.CategoryMapper;
import org.yusuf.eticaret.dto.CategoryDto;
import org.yusuf.eticaret.request.CategoryRequest;
import org.yusuf.eticaret.response.CategoryResponse;
import org.yusuf.eticaret.service.CategoryService;

@RestController
@RequestMapping("categorys")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping
    public CategoryResponse categoryResponse(@RequestBody CategoryRequest categoryRequest) {

        return CategoryMapper.toResponse(categoryService.save(CategoryMapper.toDto(categoryRequest)));

    }



}

