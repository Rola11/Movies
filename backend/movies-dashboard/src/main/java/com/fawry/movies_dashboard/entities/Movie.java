package com.fawry.movies_dashboard.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String type;

    // Constructors
    public Movie() {}

    public Movie(String title, Integer year, String type) {
        this.title = title;
        this.year = year;
        this.type = type;
    }


}

