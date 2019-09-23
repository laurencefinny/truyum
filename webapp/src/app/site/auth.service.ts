import { Injectable } from '@angular/core';
import { User } from '../site/user';
import { UserServiceService } from '../site/user-service.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn = false;
  isAdmin = false;
  accessToken: string; // JWT token
  redirectUrl = '/menuList';
  userAuthenticated: User;

  constructor(private userService: UserServiceService) { }

  logIn(username: string, password: string) {
    this.userService.authenticate(username, password).subscribe((user: User) => {
      if (user) {
        this.loggedIn = true;
        this.userAuthenticated = user;
        this.isAdmin = user.role === 'Admin';
      }
    });
  }

  logOut() {
    this.redirectUrl = '/menuList'; // reset to root url
    this.loggedIn = false;
  }

  isAdminUser() {
    return this.isAdmin;
  }
  
}
