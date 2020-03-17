import { OrderService } from 'src/app/services/order.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Order } from 'src/app/models/order';
import { Item } from 'src/app/models/item';
import { User } from 'src/app/models/user';
import { Address } from 'src/app/models/address';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  order: Order = new Order();
  customer: User = new User();
  item: Item = new Item();
  address: Address = new Address();
  newOrder: Order;
  submitted = false;
  constructor(private orderSvc: OrderService) { }

  ngOnInit() {
    localStorage.removeItem('credentials');

  }

  onSubmit() {
    this.submitted = true;
  }



  submitOrder() {
    this.order.item = this.item;
    this.order.customer = this.customer;
    this.order.shipAddress = this.address;

    this.orderSvc.submitNewOrder(this.order).subscribe(
      goodStuff => {
        this.newOrder = goodStuff;
        // this.ngOnInit();
      },

      badStuff => {
        console.error(badStuff);
      }
    );
  }

}
