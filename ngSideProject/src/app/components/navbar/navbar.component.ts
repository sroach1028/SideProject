import { Router, NavigationEnd, RouterLink } from '@angular/router';
import { Component, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { Location, LocationStrategy, PathLocationStrategy } from '@angular/common';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/user';
import { AdminComponent } from '../admin/admin.component';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

    private toggleButton: any;
    private sidebarVisible: boolean;
    public loggedIn = false;
    isAdmin: boolean;
    userSelected: User = null;
  navigationSubscription: any;

    constructor(private userSvc: UserService, private authSvc: AuthService, public location: Location,
                private element : ElementRef, private router: Router, private admincomponent: AdminComponent) {
        this.sidebarVisible = false;
        // this.navigationSubscription = this.router.events.subscribe((e: any) => {
        //   if (e instanceof NavigationEnd) {
        //     this.ngOnInit();
        //   }
        // });
      }

    ngOnInit() {
      if (this.authSvc.checkLogin()) {
        this.loggedIn = true;
        this.getUser();
      }
    }

    // ngOnDestroy(): void {
    //   if (this.navigationSubscription) {
    //     this.navigationSubscription.unsubscribe();
    //   }
    // }

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

  logout() {
    this.admincomponent.loggedIn = false;
    this.loggedIn = false;
    this.authSvc.logout();

    this.isAdmin = false;

  }

    sidebarOpen() {
        const toggleButton = this.toggleButton;
        const html = document.getElementsByTagName('html')[0];
        // console.log(html);
        // console.log(toggleButton, 'toggle');

        setTimeout(function(){
            toggleButton.classList.add('toggled');
        }, 500);
        html.classList.add('nav-open');

        this.sidebarVisible = true;
    };
    sidebarClose() {
        const html = document.getElementsByTagName('html')[0];
        // console.log(html);
        this.toggleButton.classList.remove('toggled');
        this.sidebarVisible = false;
        html.classList.remove('nav-open');
    };
    sidebarToggle() {
        // const toggleButton = this.toggleButton;
        // const body = document.getElementsByTagName('body')[0];
        if (this.sidebarVisible === false) {
            this.sidebarOpen();
        } else {
            this.sidebarClose();
        }
    };

}
