import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Film} from "../models/film";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
})
export class SearchComponent {
  searchQuery: string = '';
  movies: any[] = [];
  addingMovie: boolean = false;
  successMessage: string = '';
  constructor(private http: HttpClient) {}

  fetchMovies(query: string): void {
    const url = `http://localhost:8080/admin/movies/search?query=${query}`;
    this.http.get<any>(url).subscribe(data => {
      this.movies = data.Search || [];
    });
  }
  onSearch(): void {
    this.fetchMovies(this.searchQuery);
  }

  addMovie(movie: any): void {
    this.addingMovie = true;
    const url = 'http://localhost:8080/admin/movies';
    const filmDTO = new Film(movie.Type, movie.Year, movie.Title);
    this.http.post<any>(url, filmDTO).subscribe(
      response => {
        this.addingMovie = false;
        this.successMessage = 'Movie added successfully!';
        setTimeout(() => this.successMessage = '', 3000); // Clear message after 3 seconds
        this.onSearch(); // Refresh the movie list
      },
      error => {
        this.addingMovie = false;
        console.error('Error adding movie:', error);
      }
    );
  }
}
