import { Component, OnInit } from '@angular/core';
import {FoodServiceService } from '../../food-service.service'
import {FoodItem} from '../../item-info/food-item';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchkey:string;
  filteredList:FoodItem[];
  originalLists:FoodItem[];
  constructor(private foodList:FoodServiceService) { }

  ngOnInit() {
    this.originalLists=this.foodList.getFoodItems();
    this.filteredList=this.originalLists;
  }
  search(event:any){
    this.filteredList=this.originalLists.filter(food=>food.name.toLocaleLowerCase().includes(this.searchkey.toLocaleLowerCase()));
    this.foodList.getSubject().next(this.filteredList);
      
  }
}
