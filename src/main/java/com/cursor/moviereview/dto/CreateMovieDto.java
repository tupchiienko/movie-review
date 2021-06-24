package com.cursor.moviereview.dto;

import com.cursor.moviereview.annotation.validation.constraint.RateValueDigits;
import com.cursor.moviereview.annotation.validation.constraint.RateValueInRange;
import com.cursor.moviereview.annotation.validation.constraint.RateVotesPositiveOrZero;
import com.cursor.moviereview.entity.Rate;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.List;
import java.util.UUID;

@Data
public class CreateMovieDto {

    @NotBlank(message = "Movie name is mandatory")
    @Size(max = 64, message = "Movie description must be less than 64 characters")
    private String name;

    @NotBlank(message = "Movie description is mandatory")
    @Size(max = 2048, message = "Movie description must be less than 2048 characters")
    private String description;

    @Size(max = 128, message = "Movie photo name must be less than 128 characters")
    private String photo;

    @NotBlank(message = "Movie director name is mandatory")
    @Size(max = 64, message = "Movie director name must be less than 64 characters")
    private String directorName;

    @NotNull(message = "Rate is mandatory")
    @RateVotesPositiveOrZero
    @RateValueInRange(message = "Value out of bounds (from 0.0 to 10.0)")
    @RateValueDigits(message = "Numeric value out of bounds (<2 digits>.<2 digits> expected)")
    private Rate rate;

    @NotEmpty(message = "Movie must have at list 1 category")
    private List<UUID> categoriesId;

}
