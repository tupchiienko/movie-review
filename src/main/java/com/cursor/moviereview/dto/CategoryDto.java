package com.cursor.moviereview.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {

    @NotBlank(message = "Category name is mandatory")
    @Max(value = 64, message = "Category name must be less than 64 characters")
    private String name;

}
