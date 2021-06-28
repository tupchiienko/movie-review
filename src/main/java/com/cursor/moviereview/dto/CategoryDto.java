package com.cursor.moviereview.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDto {

    @NotBlank(message = "Category name is mandatory")
    @Size(max = 64, message = "Category name must be less than 64 characters")
    private String name;

}
