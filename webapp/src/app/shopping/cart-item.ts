import {FoodItem} from '../food/item-info/food-item';
export interface CartInterface{
    cartInterface:[
        {
            itemId:string,
            cartItem:FoodItem,
            quantity:number
        }
    ];
    total:number;
}