import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { FoodServiceService } from '../food-service.service'
import { FoodItem } from '../item-info/food-item'

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {

  editForm: FormGroup;
  cartUpdated = false;

  constructor(private productsService: FoodServiceService, private route: ActivatedRoute, private router: Router) { }
  product:FoodItem[];
  ngOnInit() {

    this.editForm = new FormGroup({
      'name': new FormControl(null, [Validators.required, Validators.maxLength(200)]),
      'imageLink': new FormControl(null, [Validators.required]),
      'price': new FormControl(null, [Validators.required, Validators.pattern('^[0-9]+$')]),
      'category': new FormControl(null, Validators.required),
      'dateOfLaunch': new FormControl(null),
      'active': new FormControl(null, Validators.required),
      'freeDelivery': new FormControl(null)
    });
    this.route.params.subscribe((params: Params) => {
      const prodId = params['id'];
      
      this.productsService.getFoodItem(prodId).subscribe((product: FoodItem) => {
        if (product) {
          this.editForm.patchValue({
            name: product.name,
            imageLink: product.imageLink,
            price: product.price,
            category: product.category,
            dateOfLaunch: product.dateOfLaunch.toISOString().substring(0,10),
            active: product.active,
            freeDelivery: product.freeDelivery
          });
        } else {
          this.router.navigate(['not-found']);
        }
      });
    });
  }

  onSubmitEditForm() {
    console.log(this.editForm);
    this.cartUpdated = true;
  }

}
