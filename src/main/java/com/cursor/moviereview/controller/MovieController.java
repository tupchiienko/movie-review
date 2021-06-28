package com.cursor.moviereview.controller;

import com.cursor.moviereview.dto.CreateMovieDto;
import com.cursor.moviereview.entity.Movie;
import com.cursor.moviereview.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Movie> addNewMovie(@Valid @RequestBody CreateMovieDto movieDto) {
        var movie = movieService.create(movieDto);
        return ResponseEntity.ok(movie);
    }
}
