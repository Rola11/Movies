import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/auth'; // Replace with your backend API URL

  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<{ role: string, status: string, username: string }> {
    return this.http.post<{ role: string, status: string, username: string }>(`${this.apiUrl}/login`, { username, password });
  }
}
