import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ItemInfoComponent } from './food/item-info/item-info.component';
import { MenuComponent } from './food/menu/menu.component';
import { RouterModule} from '@angular/router';
import {FoodServiceService} from './food/food-service.service';
import { SearchComponent } from './food/search/search/search.component';
import { CartComponent } from './shopping/cart/cart.component';
import {CartService} from './shopping/cart.service';
import { ItemEditComponent } from './food/item-edit/item-edit.component';
import { AuthService } from './site/auth.service'
import { LoginComponent } from './site/login/login.component'
import { SignupComponent } from './site/signup/signup.component'
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthGaurdService } from './site/auth-gaurd.service';
import { MenuItemServicesService } from 'src/menu-item.service';

@NgModule({
  declarations: [
    AppComponent,
    ItemInfoComponent,
    MenuComponent,
    SearchComponent,
    CartComponent,
    ItemEditComponent,
    SignupComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {
        path:'menuList',
        component: MenuComponent
      },
      {
        path:'cart',
        component: CartComponent,
        canActivate: [AuthGaurdService]
      },
      {
        path:'login',
        component: LoginComponent
      },
      {
        path:'signup',
        component: SignupComponent
      },
      {
        path: 'cartUpdated1/:id', 
        component:  ItemEditComponent
      },
    ])
  ],
  providers: [MenuItemServicesService,FoodServiceService,CartService,AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
