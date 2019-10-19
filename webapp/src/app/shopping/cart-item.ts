import {FoodItem} from '../food/item-info/food-item';
export interface CartInterface{
    menuItemList:FoodItem[],
    total:number;
}
