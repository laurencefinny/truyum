import { Component, OnInit, Output,EventEmitter, Input } from '@angular/core';
import {FoodItem} from '../item-info/food-item';
import {FoodServiceService} from '../food-service.service';
import { Observable } from 'rxjs';
import { CartService } from 'src/app/shopping/cart.service';
import { Router } from '@angular/router';
import { AuthService } from '../../site/auth.service'

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  foodItem:FoodItem[];
  originalList: FoodItem[];

  cartAdded=false;
  constructor(private foodService:FoodServiceService,private cartService:CartService, private authService: AuthService,
    private router: Router) { 
  
  }
  
  ngOnInit() {
    this.foodItem=this.foodService.getFoodItems();
    this.foodService.getSubject().subscribe((data)=>{
     // this.foodItem=data;
      this.originalList = [...data]; // maintain original copy
      this.foodItem = [...data]; // update list rendered in template
    });

    this.foodService.filter.subscribe((obj: { name: string }) => {
      if (obj.name !== '') { // filter from original list for search text, and update list rendered
        const result = this.originalList.filter(prod => prod.name.toLowerCase().includes(obj.name.toLowerCase()));
        this.foodItem = result ? result : [];
      } else { // reset to original product list, if not search text entered
        this.foodItem = [...this.originalList];
      }
    });
  
  }
  addedToCart(foodId:number){
    this.cartService.addToCart(foodId,1);//hardCode it to 1
    if (!this.authService.loggedIn) {
      this.router.navigate(['/cart']);
    }
  }

}
