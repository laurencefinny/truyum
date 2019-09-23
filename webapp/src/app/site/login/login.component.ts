import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [`
    input.ng-invalid.ng-touched {
      border: 1px solid red;
      background-color: #fdd;
    }
  `]
})
export class LoginComponent implements OnInit {

  isLoginValid = true;
  authSource: string;

  constructor(private router: Router,
    private route: ActivatedRoute,
    private authService: AuthService) { }

  ngOnInit() {
    this.route.queryParams.subscribe((params: Params) => {
      this.authSource = params['from'];
    });
  }

  onSubmit(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;
    if (username === 'john') { // temporary to show the invalid user login
      this.isLoginValid = false;
    } else {
      this.authService.logIn(username, password);
      this.router.navigate([this.authService.redirectUrl]);
    }
  }

}
