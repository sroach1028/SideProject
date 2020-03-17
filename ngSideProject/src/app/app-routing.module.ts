import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { OrderComponent } from './components/order/order.component';
import { RegisterComponent } from './components/register/register.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';
import { LoginComponent } from './components/login/login.component';
import { AccountComponent } from './components/account/account.component';
import { AdminComponent } from './components/admin/admin.component';
import { ContentComponent } from './components/content/content.component';


const routes: Routes = [
  {path : 'home', component: HomeComponent},
  {path : 'content', component: ContentComponent},
  {path : 'order', component: OrderComponent},
  {path : 'register', component: RegisterComponent},
  {path : 'subscribe', component: SubscribeComponent},
  {path : 'login', component: LoginComponent},
  {path : 'account', component: AccountComponent},
  {path : 'admin', component: AdminComponent},
  {path: '', pathMatch: 'full', redirectTo: 'home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: false})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
