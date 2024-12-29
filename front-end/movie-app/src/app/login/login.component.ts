import {Component} from '@angular/core';
import {AuthService} from "../auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent {
  username: string = '';
  password: string = '';


  constructor(private authService: AuthService, private router: Router) {
  }

  onSubmit() {

    this.authService.login(this.username, this.password).subscribe(role => {
      if (role === 'ADMIN') {
        this.router.navigate(['/admin-dashboard']);
      } else if (role === 'USER') {
        this.router.navigate(['/user-dashboard']);
      }
    });
  }
}

