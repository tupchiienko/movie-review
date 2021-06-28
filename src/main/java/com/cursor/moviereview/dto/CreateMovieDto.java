package com.cursor.moviereview.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
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

    @NotNull(message = "rateValue is mandatory")
    @DecimalMin(value = "1.0", message = "Rate value must not be less than 1.0")
    @DecimalMax(value = "10.0", message = "Rate value must not be greater than 10.0")
    @Digits(integer = 2, fraction = 2, message = "Numeric value out of bounds (<2 digits>.<2 digits> expected)")
    private BigDecimal rateValue;

    @PositiveOrZero(message = "Votes count must not be less than 0")
    private long votesCount;

    @NotEmpty(message = "Movie must have at list 1 category")
    private List<UUID> categoriesId;

}
