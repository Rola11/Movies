import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-movie-list',
  templateUrl: './user-movie-list.component.html',
  styleUrls: ['./user-movie-list.component.scss']
})
export class UserMovieListComponent implements OnInit {
  userMovies: any[] = [];

  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit(): void {
    this.fetchUserMovies();
  }

  fetchUserMovies(): void {
    const url = 'http://localhost:8080/user/movies';
    this.http.get<any>(url).subscribe(data => {
      this.userMovies = data;
    });
  }

  viewMovieDetails(movieId: number): void {
    this.router.navigate(['/movie-details', movieId]);
  }
}
