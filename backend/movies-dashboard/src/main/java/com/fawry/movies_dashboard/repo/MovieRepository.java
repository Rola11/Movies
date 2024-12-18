package com.fawry.movies_dashboard.repo;


import com.fawry.movies_dashboard.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
