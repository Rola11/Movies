package com.fawry.movies_dashboard.controller;

import com.fawry.movies_dashboard.entities.Movie;
import com.fawry.movies_dashboard.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/movies")
public class UserMovieController {
    private final MovieService movieService;

    public UserMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieDetails(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
}