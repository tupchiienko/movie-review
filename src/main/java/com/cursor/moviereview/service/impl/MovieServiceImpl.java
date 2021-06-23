package com.cursor.moviereview.service.impl;

import com.cursor.moviereview.dto.CreateMovieDto;
import com.cursor.moviereview.entity.Movie;
import com.cursor.moviereview.repository.MovieRepo;
import com.cursor.moviereview.service.CategoryService;
import com.cursor.moviereview.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepo movieRepo;
    private final CategoryService categoryService;

    @Override
    public Movie create(CreateMovieDto movieDto) {
        var movie = new Movie();
        var categories = categoryService.findAllById(movieDto.getCategoriesId());
        movie.setName(movieDto.getName());
        movie.setDescription(movieDto.getDescription());
        movie.setPhoto(movieDto.getPhoto());
        movie.setDirectorName("John Doe");
        movie.setRate(movieDto.getRate());
        movie.setCategories(categories);
        return movieRepo.save(movie);
    }
}
