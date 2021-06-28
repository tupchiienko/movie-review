package com.cursor.moviereview.service;

import com.cursor.moviereview.dto.CategoryDto;
import com.cursor.moviereview.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> findAllById(List<UUID> ids);

    Category create(CategoryDto categoryDto);

}
