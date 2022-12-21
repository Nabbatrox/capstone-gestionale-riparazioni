import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from './imodels/login';
import { User } from './models/user';


type AuthResponse = {

  accessToken: string,
  user:User

}

@Injectable({
  providedIn: 'root'
})

export class AuthService   {

  apiAuthUrl: string = 'http://localhost:8080/auth';
  apiUrl: string = 'http://localhost:8080/api/users';

  constructor(private http:HttpClient, private route:Router) {}

  saveAuthToLocal(access:AuthResponse){

    localStorage.setItem('user-access',JSON.stringify(access))

  }

  saveAuthToSession(access:AuthResponse){

    sessionStorage.setItem('user-access',JSON.stringify(access))

  }

  isUserLogged(): boolean{
    let local = localStorage.getItem('user-access');
    let session = sessionStorage.getItem('user-session');

    if(local != null || session != null){
      return true;
    }else{
      this.route.navigate(['/login']);
      return false;
    }  

  }

  logOut(){
        
    localStorage.removeItem('user-access')
    sessionStorage.removeItem('user-access')
  
  }


  login(loginData:Login){

    return this.http.post<AuthResponse>(this.apiAuthUrl+'/login', loginData)

  }

  register(register:User){

    return this.http.post<AuthResponse>(this.apiUrl+'/register', register)

  }

  getLogged(){
    let exit = this.isUserLogged();

    if (exit) {
    let logged : string | null = localStorage.getItem('user-access')
    return logged ? JSON.parse(logged).user : null
  }
    else {
    let logged : string | null = sessionStorage.getItem('user-access')
    return logged ? JSON.parse(logged).user : null
  }

  

}
}

