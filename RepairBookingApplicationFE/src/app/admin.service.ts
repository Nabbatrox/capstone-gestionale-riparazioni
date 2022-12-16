import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GenCrudService } from './gencrud.service';
import { Booking } from './models/booking';

@Injectable({
  providedIn: 'root'
})
export class AdminService extends GenCrudService <Booking> {

  constructor(private http:HttpClient) {
    super(http, 'http://localhost:8080/users');
  }
  
}
