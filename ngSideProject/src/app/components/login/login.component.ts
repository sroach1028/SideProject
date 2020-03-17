import { Component, OnInit, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/models/user';
import { NavigationEnd, Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnDestroy {

  constructor(private authSvc: AuthService, private router: Router) {
    this.navigationSubscription = this.router.events.subscribe((e: any) => {
    // If it is a NavigationEnd event re-initalise the component
    if (e instanceof NavigationEnd) {
      this.ngOnInit();
    }
  });
}
  navigationSubscription;


  ngOnInit() {
  }

  login(form: NgForm) {
    console.log('made it');
    const user: User = form.value;
    this.authSvc.login(user.username, user.password).subscribe(
      goodStuff => {
        console.log('made it to login');
        this.router.navigateByUrl('/admin');

      },

      badStuff => {
        console.error(badStuff);


      }
    );
  }

  register(form: NgForm) {
    const user = new User();
    user.firstName = form.value.firstName;
    user.lastName = form.value.lastName;
    user.username = form.value.email;
    user.email = form.value.email;
    user.password = form.value.password;
    user.phone = form.value.phone;
    user.role = 'standard';
    user.enabled = true;

    // const address = new Address();
    // address.street = form.value.street;
    // address.state = form.value.state;
    // address.city = form.value.city;
    // address.zip = form.value.zip;

    // user.address = address;
    // this.error = false;
    this.authSvc.register(user).subscribe(
      data => {
        this.authSvc.login(user.username, user.password).subscribe(
          next => {
            this.router.navigateByUrl('/account');
          },
          error => {
            console.error('RegisterComponent.register(): error logging in.');
          }
        );
      },
      err => {
        console.error('RegisterComponent.register(): error registering.');
        console.error(err);
        // this.error = true;
      }
    );
  }

  ngOnDestroy() {
    // avoid memory leaks here by cleaning up after ourselves. If we
    // don't then we will continue to run our initialiseInvites()
    // method on every navigationEnd event.
    if (this.navigationSubscription) {
      this.navigationSubscription.unsubscribe();
    }
  }

}
