import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const role = localStorage.getItem('role');
    if (role) {
      const cloned = req.clone({
        setHeaders: {
          'Role': role,
          'Content-Type': 'application/json' // Set Content-Type to application/json
        }
      });
      return next.handle(cloned);
    }
    return next.handle(req);
  }
}
