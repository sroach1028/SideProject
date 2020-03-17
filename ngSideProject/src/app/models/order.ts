import { Item } from './item';
import { User } from './user';
import { Address } from './address';

export class Order {
  id: number;
  datePlaced: String;
  dateRequested: String;
  dateFulfilled: String;
  customer: User;
  ingredients: String;
  shipAddress: Address;
  price: number;
  accepted: string;
  item: Item;
  itemQuantity: number;
  designSpecified: String;
  occasion: String;
  allergiesSpecified: String;
  specialRequests: String;

  constructor(
    datePlaced?: string,
    dateRequested?: string,
    ingredients?: string,
    designSpecified?: string,
    allergiesSpecified?: string,
    customer?: User,
    shipAddress?: Address,
    item?: Item,
    itemQuantity?: number
  )
  {
    this.allergiesSpecified = allergiesSpecified;
    this.ingredients = ingredients;
    this.designSpecified = designSpecified;
    this.datePlaced = datePlaced;
    this.dateRequested = dateRequested;
    this.customer = customer;
    this.shipAddress = shipAddress;
    this.item = item;
    this.itemQuantity = itemQuantity;
  }

}
