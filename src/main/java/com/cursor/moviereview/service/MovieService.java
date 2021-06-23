package com.cursor.moviereview.service;

import com.cursor.moviereview.dto.CreateMovieDto;
import com.cursor.moviereview.entity.Movie;

public interface MovieService {

    Movie create(CreateMovieDto movieDto);

}
