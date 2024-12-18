package com.fawry.movies_dashboard.service;

import com.fawry.movies_dashboard.dto.OmdbMovieResponse;
import com.fawry.movies_dashboard.entities.Movie;
import com.fawry.movies_dashboard.repo.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final OmdbService omdbService;

    public MovieService(MovieRepository movieRepository, OmdbService omdbService) {
        this.omdbService = omdbService;
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public OmdbMovieResponse fetchMoviesFromOmdb(String searchQuery, int page) {
        OmdbMovieResponse response = omdbService.fetchMoviesFromOmdb(searchQuery, page);
        List<String> localMovieTitles = movieRepository.findAll().stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        response.getSearch().removeIf(movie -> localMovieTitles.contains(movie.getTitle()));
        return response;
    }
}