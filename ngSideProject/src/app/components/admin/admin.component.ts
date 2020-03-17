import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { AuthService } from 'src/app/services/auth.service';
import { Router, NavigationEnd } from '@angular/router';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  public loggedIn = false;
  isAdmin: boolean;
  userSelected: User = null;
  navigationSubscription: any;

  constructor(private userSvc: UserService, private authSvc: AuthService, private router: Router) {

    this.navigationSubscription = this.router.events.subscribe((e: any) => {
      // If it is a NavigationEnd event re-initalise the component
      if (e instanceof NavigationEnd) {
        this.ngOnInit();
      }
    });
  }

  ngOnInit() {

    if (this.authSvc.checkLogin()) {
      this.loggedIn = true;
      this.getUser();
    }
  }

  ngOnDestroy(): void {
    if (this.navigationSubscription) {
      this.navigationSubscription.unsubscribe();
    }

  }

getUser() {
  this.userSvc.getUserByUsername().subscribe(
    data => {
      if (data.username === 'admin') {
        this.isAdmin = true;
      }
      this.userSelected = data;
    },
    err => console.error('Get User Error in Nav-Bar Component.ts')
  );

  this.userSelected = null;
}

}
