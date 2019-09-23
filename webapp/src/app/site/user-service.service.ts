import { Injectable } from '@angular/core';
import { Observable, Observer } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor() { }

  authenticate(username: string, password: string): Observable<User> {
    return Observable.create((observer: Observer<any>) => { // temporary
      if (username !== 'admin') {
        observer.next({ username, firstName: 'Divya', lastName: 'Yamparala', role: 'Customer', accessToken: 'JWT-TOKEN' });
      } else {
        observer.next({ username, firstName: 'Divya', lastName: 'Yamparala', role: 'Admin', accessToken: 'JWT-TOKEN' });
      }
      return null;
    });
  }
}
