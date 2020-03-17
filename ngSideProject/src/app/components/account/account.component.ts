import { Component, OnInit, OnDestroy } from '@angular/core';
import { User } from 'src/app/models/user';
import { UserService } from 'src/app/services/user.service';
import { Router, NavigationEnd } from '@angular/router';
import { OrderService } from 'src/app/services/order.service';
import { Order } from 'src/app/models/order';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})

export class AccountComponent implements OnInit, OnDestroy {
  user: User = null;
  navigationSubscription: any;
  orders: Order[] = [];

  constructor(private orderSvc: OrderService, private userSvc: UserService, private router: Router) {
    this.navigationSubscription = this.router.events.subscribe((e: any) => {
      // If it is a NavigationEnd event re-initalise the component
        this.ngOnInit();
    });
  }

  ngOnInit() {
    this.orderSvc.getAllOrders().subscribe(
      orderData => {
        this.orders = orderData;
      },
      err => {
        console.error(err);
      }
    );
  }

  ngOnDestroy(): void {
    if (this.navigationSubscription) {
      this.navigationSubscription.unsubscribe();
    }
  }

}
