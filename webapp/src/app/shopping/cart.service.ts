import { Injectable, Output,EventEmitter } from '@angular/core';
import { CartInterface} from '../shopping/cart-item';
import { FoodItem } from '../food/item-info/food-item';
import { FoodServiceService } from '../food/food-service.service';
import { UUID } from 'angular2-uuid';


@Injectable({
  providedIn: 'root'
})
export class CartService {
  @Output() cartUpdated=new EventEmitter<FoodItem>();
  cart: CartInterface = {
    cartInterface: null,
    total: 0
  };
  
  i: any;
  total:number;
  constructor(private foodService:FoodServiceService) { }
  getCart() {
    return this.cart;
  }
  getTotal(){
    for(this.i;this.i<this.cart.cartInterface.length;this.i++){
      this.cart.total+=this.cart.cartInterface[this.i].cartItem.price;
    }
    return this.cart.total;
  }
  addToCart(productId:number,quantity:number){
    const uid =UUID.UUID();

  //  console.log(uid)
    this.foodService.getFoodItem(productId).subscribe((foodTobeAdded:FoodItem)=>{
      if(this.cart.cartInterface==null){
        this.cart.cartInterface=[{itemId:uid,cartItem:foodTobeAdded,quantity}];
        this.cart.total=foodTobeAdded.price;
      }else{
        this.cart.cartInterface.push({itemId:uid,cartItem:foodTobeAdded,quantity});
        this.cart.total+=foodTobeAdded.price;
      }
    }); 
  }
  removeFromCart(itemtId: string) {
  const itemIndex=this.cart.cartInterface.findIndex (cartItem=>cartItem.itemId===itemtId);
 // console.log(itemtId+'service'); 
  const itemToBeRemoved=this.cart.cartInterface.splice(itemIndex,1)[0];
   this.cart.total-=itemToBeRemoved.cartItem.price;
  }

  clearCart() {
    this.cart.cartInterface = null;
    this.cart.total = 0;
  }

}
