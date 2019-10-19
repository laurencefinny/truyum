import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

import { environment } from 'src/environments/environment';

import { FoodItem } from './app/food/item-info/food-item';
import { UserServiceService } from './app/site/user-service.service';


@Injectable({
  providedIn: 'root'
})
export class MenuItemServicesService {
  filter = new Subject();
  private subject=new Subject<FoodItem[]>();
  constructor(private httpClient:HttpClient,private userService:UserServiceService) { }
  getAllMenuItems():Observable<any>{

  
    if(this.userService.getToken()){
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());  
    
    return this.httpClient.get<FoodItem[]>(`${environment.baseUrl}`+'menu-items',{headers});
    }
    else{
      let username='default';
      let password='pwd';
      let headers = new HttpHeaders();
      headers = headers.set('Authorization', 'Basic ' + btoa(username+':'+password));  
      return this.httpClient.get<FoodItem[]>(`${environment.baseUrl}`+'menu-items',{headers});
    }
  }
  getSubject():Subject<FoodItem[]>{
    return this.subject;
  }
  getFoodItem(id:number):Observable<FoodItem>{
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken());  
    return this.httpClient.get<FoodItem>(environment.baseUrl+'menu-items/'+id,{headers});
  }
  modifyItem(foodItem:FoodItem):Observable<any>{
  let headers = new HttpHeaders();
  headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
  return this.httpClient.put<FoodItem>(environment.baseUrl+'menu-items',foodItem,{headers});
  }
  addToCart(menuItemId:number,userId:String){ 
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', 'Bearer ' + this.userService.getToken()); 
    console.log(environment.baseUrl+'carts/'+userId+'/'+menuItemId);
    return this.httpClient.post<FoodItem>(environment.baseUrl+'carts/'+userId+'/'+menuItemId,null,{headers});
  }
}
