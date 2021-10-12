package com.cursor.moviereview.service.impl;

import com.cursor.moviereview.dto.CategoryDto;
import com.cursor.moviereview.entity.Category;
import com.cursor.moviereview.repository.CategoryRepo;
import com.cursor.moviereview.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> findAllById(List<UUID> ids) {
        return categoryRepo.findAllById(ids);
    }

    @Override
    public Category create(CategoryDto categoryDto) {
        var category = new Category();
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(categoryDto, category);
        return categoryRepo.save(category);
    }
}
