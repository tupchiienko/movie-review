package com.cursor.moviereview.controller;

import com.cursor.moviereview.dto.CategoryDto;
import com.cursor.moviereview.entity.Category;
import com.cursor.moviereview.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        var newCategory = categoryService.create(categoryDto);
        return ResponseEntity.ok(newCategory);
    }

}
