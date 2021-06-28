package com.cursor.moviereview.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class ReviewDto {

    @NotBlank(message = "Review message is mandatory")
    @Size(max = 2048, message = "Review message must be less than 2048 characters")
    private String message;

    @PositiveOrZero(message = "Likes count must not be less than 0")
    private int likesCount;

    @PositiveOrZero(message = "Dislikes count must not be less than 0")
    private int dislikesCount;

}
