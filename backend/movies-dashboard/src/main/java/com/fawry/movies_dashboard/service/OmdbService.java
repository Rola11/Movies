package com.fawry.movies_dashboard.service;

import com.fawry.movies_dashboard.dto.OmdbMovieResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbService {

    private final String apiKey = "710e229a"; // Your OMDB API key
    private final RestTemplate restTemplate = new RestTemplate();

    public OmdbMovieResponse fetchMoviesFromOmdb(String searchQuery, int page) {
        String url = String.format("http://www.omdbapi.com/?s=%s&page=%d&apikey=%s", searchQuery, page, apiKey);

        String jsonResponse = restTemplate.getForObject(url, String.class);
        System.out.println(jsonResponse);
        return restTemplate.getForObject(url, OmdbMovieResponse.class);


    }
}