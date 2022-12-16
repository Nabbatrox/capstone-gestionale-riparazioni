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





 ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
