import { Injectable } from '@angular/core';

import { UserServiceService } from '../site/user-service.service';
import { User } from './user';
import { ActivatedRoute, Params } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedIn = false;
  isAdmin = false;
  accessToken: string; 
  authSource:String
  redirectUrl = '/menuList';
  userAuthenticated: User;
  userAuthenticated1:String;
  
  constructor(private userService: UserServiceService, private route: ActivatedRoute) { }
  
  logIn(username: string, password: string) {
    this.userService.authenticate(username, password).subscribe((data) => {
      if (data) {
        this.loggedIn = true;
        console.log("helloAuth");
        this.userAuthenticated = data;
        this.userAuthenticated1=username;
        this.isAdmin = data.role === 'ROLE_ADMIN';
        console.log(this.isAdmin);

      }
    });
  }

  logOut() {
    this.redirectUrl = '/menuList'; 
    this.loggedIn = false;
    this.userService.logout();
  }

  isAdminUser() {
    return this.isAdmin;
  }
  
}
