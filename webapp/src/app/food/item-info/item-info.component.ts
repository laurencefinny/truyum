import { Component, OnInit, Input, Output ,EventEmitter} from '@angular/core';
import { FoodItem } from './food-item';
import {FoodServiceService} from '../food-service.service';
import { CartService } from 'src/app/shopping/cart.service';
import { AuthService } from '../../site/auth.service';
import { MenuItemServicesService } from 'src/menu-item.service';


@Component({
  selector: 'app-item-info',
  templateUrl: './item-info.component.html',
  styleUrls: ['./item-info.component.css']
})

export class ItemInfoComponent implements OnInit {
  foodItem:FoodItem[];
  @Input() foodIte:FoodItem;
  @Output() cartUpdated: EventEmitter<number> = new EventEmitter<number>();
  cartAdded=false;
  constructor(private foodService:FoodServiceService,private cartService:CartService,private authService: AuthService,private menuitemService:MenuItemServicesService){
  }
  addToCart(foodId:number){
    this.cartUpdated.emit(foodId);
    this.cartAdded=true;
    setTimeout(() => {
      this.cartAdded = false;
    }, 1000);
   
  }
  ngOnInit() {
    this.menuitemService.getAllMenuItems().subscribe((data)=>{
      this.foodItem=data;
    });
    this.menuitemService.getSubject().subscribe((data)=>{
      this.foodItem=data;
    });
  
  }

  isEditAllowed() {
    return this.authService.loggedIn && this.authService.isAdminUser();
  }

} 
