import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

 { path: '', loadChildren: () => import('./pages/home/home.module')
 .then(m => m.HomeModule) },

 { path: 'login', loadChildren: () => import('./auth/login/login.module')
 .then(m => m.LoginModule) },

 { path: 'register', loadChildren: () => import('./auth/register/register.module')
 .then(m => m.RegisterModule) },

 { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },

 { path: 'services', loadChildren: () => import('./pages/services/services.module').then(m => m.ServicesModule) },

 { path: 'booking', loadChildren: () => import('./pages/booking/booking.module').then(m => m.BookingModule) },

 { path: 'profile', loadChildren: () => import('./pages/profile/profile.module').then(m => m.ProfileModule) },

 { path: 'aboutUs', loadChildren: () => import('./pages/about-us/about-us.module').then(m => m.AboutUsModule) },





 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
