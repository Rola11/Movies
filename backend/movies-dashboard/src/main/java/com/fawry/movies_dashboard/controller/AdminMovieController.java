package com.fawry.movies_dashboard.controller;

import com.fawry.movies_dashboard.dto.OmdbMovieResponse;
import com.fawry.movies_dashboard.entities.Movie;
import com.fawry.movies_dashboard.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/movies")
public class AdminMovieController {
    private final MovieService movieService;

    public AdminMovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

    @GetMapping("/search")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public OmdbMovieResponse searchMovies(@RequestParam String query, @RequestParam(defaultValue = "1") int page) {
        return movieService.fetchMoviesFromOmdb(query, page);
    }
}