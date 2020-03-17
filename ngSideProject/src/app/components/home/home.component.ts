import { OrderService } from 'src/app/services/order.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Order } from 'src/app/models/order';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  navigationSubscription: any;
  order: Order = null;
  constructor(private router: Router, private orderSvc: OrderService) {
    this.navigationSubscription = this.router.events.subscribe((e: any) => {
      // If it is a NavigationEnd event re-initalise the component
      if (e instanceof NavigationEnd) {
        window.scrollTo(0,0);
        this.ngOnInit();
      }
    });
  }

  trackOrder(form: NgForm){
    const id = form.value.id;
    const email = form.value.email;
    this.orderSvc.trackOrder(id, email).subscribe(
      goodStuff => {
        this.order = goodStuff;
      },
      badStuff => {
        console.error(badStuff);
      }
    );
  }

  ngOnInit() {
    localStorage.removeItem('credentials');

  }

}
