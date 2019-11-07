import { Component, OnInit, Output,EventEmitter, Input } from '@angular/core';
import {FoodItem} from '../item-info/food-item';
import {FoodServiceService} from '../food-service.service';

import { CartService } from 'src/app/shopping/cart.service';
import { Router } from '@angular/router';
import { AuthService } from '../../site/auth.service'
import { UserServiceService } from 'src/app/site/user-service.service';
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
    private router: Router,private menuItemService:MenuItemServicesService,private userService:UserServiceService) { 
  
  }
  
  ngOnInit() {
    this.menuItemService.getAllMenuItems().subscribe((data)=>{
      this.foodItem=data;
    })
    this.menuItemService.getSubject().subscribe((data)=>{
     // this.foodItem=data;
      this.originalList = [...data]; // maintain original copy
      this.foodItem = [...data]; // update list rendered in template
    });

    this.menuItemService.filter.subscribe((obj: { name: string }) => {
      if (obj.name !== '') { // filter from original list for search text, and update list rendered
        const result = this.originalList.filter(prod => prod.name.toLowerCase().includes(obj.name.toLowerCase()));
        this.foodItem = result ? result : [];
      } else { // reset to original product list, if not search text entered
        this.foodItem = [...this.originalList];
      }
    });
  
  }
  addedToCart(foodId:number){
    if (!this.authService.loggedIn) {
      this.router.navigate(['/cart']);
    }else{
    this.menuItemService.addToCart(foodId,this.userService.user).subscribe((data)=>{
      console.log(data);
    });
  }
  }

}
