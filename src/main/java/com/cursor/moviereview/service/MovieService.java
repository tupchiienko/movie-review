package com.cursor.moviereview.service;

import com.cursor.moviereview.dto.MovieDto;
import com.cursor.moviereview.dto.ReviewDto;
import com.cursor.moviereview.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MovieService {

    Movie create(MovieDto movieDto);

    void delete(UUID id);

    Movie update(UUID id, MovieDto movieDto);

    Movie findById(UUID id);

    Page<Movie> findAllPaged(Pageable pageable);

    Movie addReview(UUID id, ReviewDto reviewDto);

    Movie updateReview(UUID reviewId, ReviewDto reviewDto);

    Movie deleteReview(UUID reviewId);

}
