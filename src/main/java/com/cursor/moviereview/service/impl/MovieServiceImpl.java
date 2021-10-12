package com.cursor.moviereview.service.impl;

import com.cursor.moviereview.dto.MovieDto;
import com.cursor.moviereview.dto.ReviewDto;
import com.cursor.moviereview.entity.Movie;
import com.cursor.moviereview.entity.Review;
import com.cursor.moviereview.repository.MovieRepo;
import com.cursor.moviereview.repository.ReviewRepo;
import com.cursor.moviereview.service.CategoryService;
import com.cursor.moviereview.service.MovieService;
import com.cursor.moviereview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;
    private final ReviewService reviewService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Override
    public Movie create(MovieDto movieDto) {
        var movie = new Movie();
        modelMapper.map(movieDto, movie);
        var categories = categoryService.findAllById(movieDto.getCategoriesId());
        movie.setCategories(categories);
        return movieRepo.save(movie);
    }

    @Override
    public void delete(UUID id) {
        movieRepo.deleteById(id);
    }

    @Override
    public Movie update(UUID id, MovieDto movieDto) {
        var movie = movieRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        var categories = categoryService.findAllById(movieDto.getCategoriesId());
        modelMapper.map(movieDto, movie);
        movie.setCategories(categories);
        movie = movieRepo.save(movie);
        return movie;
    }

    @Override
    public Movie findById(UUID id) {
        return movieRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Page<Movie> findAllPaged(Pageable pageable) {
        return movieRepo.findAll(pageable);
    }

    @Override
    public Movie addReview(UUID id, ReviewDto reviewDto) {
        var movie = movieRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        var review = reviewService.create(reviewDto);
        var movieReviews = movie.getReviews();
        if (movieReviews == null) {
            movie.setReviews(new ArrayList<>());
        }
        movie.getReviews().add(review);
        movie = movieRepo.save(movie);
        return movie;
    }

    @Override
    public Movie updateReview(UUID reviewId, ReviewDto reviewDto) {
        var review = reviewService.update(reviewId, reviewDto);
        return null;
    }

    @Override
    public Movie deleteReview(UUID reviewId) {
        return null;
    }
}
