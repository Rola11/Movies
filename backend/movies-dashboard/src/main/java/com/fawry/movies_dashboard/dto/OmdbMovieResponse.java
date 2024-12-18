package com.fawry.movies_dashboard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class OmdbMovieResponse {
    @JsonProperty("Response")
    private String response; // Maps to "Response" in JSON

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Search")
    private List<MovieResponse> search; // Maps to "Search" in JSON
}

