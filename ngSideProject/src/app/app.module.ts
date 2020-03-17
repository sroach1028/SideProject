import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { OrderComponent } from './components/order/order.component';
import { ExamplesComponent } from './components/examples/examples.component';
import { RegisterComponent } from './components/register/register.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';
import { LoginComponent } from './components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AccountComponent } from './components/account/account.component';
import { AdminComponent } from './components/admin/admin.component';
import { AddcontentComponent } from './components/addcontent/addcontent.component';
import { ContentComponent } from './components/content/content.component';
import { PublicnavComponent } from './components/publicnav/publicnav.component';
import { SuccessComponent } from './components/success/success.component';
import { FormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    OrderComponent,
    ExamplesComponent,
    RegisterComponent,
    SubscribeComponent,
    LoginComponent,
    AccountComponent,
    AdminComponent,
    AddcontentComponent,
    ContentComponent,
    PublicnavComponent,
    SuccessComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [AdminComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
