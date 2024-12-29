import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  localMovies: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchLocalMovies();
  }

  fetchLocalMovies(): void {
    const url = 'http://localhost:8080/admin/movies';
    this.http.get<any>(url).subscribe(data => {
      this.localMovies = data;
    });
  }

  deleteMovie(movieId: number): void {
    const url = `http://localhost:8080/admin/movies/${movieId}`;
    this.http.delete<any>(url).subscribe(
      response => {
        this.fetchLocalMovies(); // Refresh the local movie list
      },
      error => {
        console.error('Error deleting movie:', error);
      }
    );
  }
}
