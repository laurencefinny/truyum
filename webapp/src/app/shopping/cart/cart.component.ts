import { Component, OnInit } from '@angular/core';
import { CartInterface } from '../cart-item';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart:CartInterface;
  constructor(private cartService:CartService) {
    this.cart=cartService.getCart();
   }
   onRemoveItem(itemid:string){
   //  console.log(itemid+'component');
    this.cartService.removeFromCart(itemid);
   }
  ngOnInit() {
    
  }

}
