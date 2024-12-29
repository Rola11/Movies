import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-film-details',
  templateUrl: './film-details.component.html',
  styleUrls: ['./film-details.component.scss']
})
export class FilmDetailsComponent implements OnInit {
  movie: any;

  constructor(private route: ActivatedRoute,
              private http: HttpClient,
              private  router: Router) {}


  ngOnInit(): void {
    const movieId = this.route.snapshot.paramMap.get('id');
    if (movieId) {
      this.fetchMovieDetails(movieId);
    }
  }

  fetchMovieDetails(movieId: string): void {
    const url = `http://localhost:8080/user/movies/${movieId}`;
    this.http.get<any>(url).subscribe(data => {
      this.movie = data;
    });
  }
  goBack(): void {
    this.router.navigate(['/user-movies']);
  }


}
