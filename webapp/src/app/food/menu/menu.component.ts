import { Component, OnInit, Output,EventEmitter, Input } from '@angular/core';
import {FoodItem} from '../item-info/food-item';
import {FoodServiceService} from '../food-service.service';

import { CartService } from 'src/app/shopping/cart.service';
import { Router } from '@angular/router';
import { AuthService } from '../../site/auth.service'
import { MenuItemServicesService } from 'src/menu-item.service';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  foodItem:FoodItem[];
  originalList: FoodItem[];

  cartAdded=false;
  constructor(private cartService:CartService, private authService: AuthService,
    private router: Router,private menuItemService:MenuItemServicesService) { 
  
  }
  
  ngOnInit() {
    this.menuItemService.getAllMenuItems().subscribe((data)=>{
      this.foodItem=data;
    })
    this.menuItemService.getSubject().subscribe((data)=>{
     
      this.originalList = [...data]; 
      this.foodItem = [...data]; 
    });

    this.menuItemService.filter.subscribe((obj: { name: string }) => {
      if (obj.name !== '') { 
        const result = this.originalList.filter(prod => prod.name.toLowerCase().includes(obj.name.toLowerCase()));
        this.foodItem = result ? result : [];
      } else { 
        this.foodItem = [...this.originalList];
      }
    });
  
  }
  addedToCart(foodId:number){
    if (!this.authService.loggedIn) {
      this.router.navigate(['/cart']);
    }else{
    this.menuItemService.addToCart(foodId,this.authService.userAuthenticated1).subscribe((data)=>{
      console.log(data);
    });
  }
  }

}
