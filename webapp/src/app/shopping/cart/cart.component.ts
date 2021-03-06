import { Component, OnInit } from '@angular/core';
import { CartInterface } from '../cart-item';
import { CartService } from '../cart.service';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/site/auth.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart:CartInterface;
  cartExists:boolean;
  constructor(private cartService:CartService,private router: Router,private authService:AuthService) {
    cartService.getCart().subscribe((data)=>{
      this.cart=data;
      if(this.cart){
        if(this.cart.total==0 && this.cart.menuItemList== null){
          this.cartExists=false;
        }else{
          this.cartExists=true;
        }
        }else{
          this.cartExists=false;
        }
    });
   }
   onRemoveItem(itemid:string){
   //  console.log(itemid+'component');
 
    this.cartService.removeFromCart(itemid).subscribe((data)=>{
      console.log(data+" "+itemid);
    });
    this.cartService.getCart().subscribe((data)=>{
   
      if(data==null){
        this.cartExists=false;
      }
    });
   }
  ngOnInit() {
    
  }
  redirect(event:any){
    this.router.navigate([this.authService.redirectUrl]);
  }

}
