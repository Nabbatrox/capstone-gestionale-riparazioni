import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenCrudService } from './gencrud.service';
import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService extends GenCrudService <User> {

  constructor(private http:HttpClient) {
    super(http, 'http://localhost:8080/users');
  }

  apiUsers:string= 'http://localhost:8080/users'

  getUserById(id:number | undefined){
    return this.http.get<User[]>(this.apiUsers+ '/?id='+ id)
  }
}
