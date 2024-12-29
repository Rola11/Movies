import { Component } from '@angular/core';
import { AuthService } from "../auth.service";
import { Router } from "@angular/router";
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit() {
    this.errorMessage = ''; // Reset error message
    this.authService.login(this.username, this.password).pipe(
      catchError(error => {
        this.errorMessage = 'Login failed. Please try again.';
        return of(null);
      })
    ).subscribe(response => {
      if (response && response.status === 'success') {
        localStorage.setItem('role', response.role); // Store role in local storage
        if (response.role === 'ROLE_ADMIN') {
          this.router.navigate(['/search']);
        } else if (response.role === 'ROLE_USER') {
          this.router.navigate(['/user-movies']);
        }
      }
    });
  }
}
