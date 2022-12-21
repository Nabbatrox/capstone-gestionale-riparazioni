import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GenCrudService } from './gencrud.service';
import { BookingDTO } from './imodels/booking-dto';
import { Booking } from './models/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http:HttpClient) {}
  
  apiUrl: string = 'http://localhost:8080/api/booking';

  getAllBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(this.apiUrl+'/getAll')
  }

  getAllBookingsByUserId(id: number): Observable<Booking[]> {
    return this.http.get<Booking[]>(this.apiUrl+'/getAllByUserId/'+id)
  }

  addBooking(bookingDTO: BookingDTO): Observable<Booking>{
    return this.http.post<Booking>(this.apiUrl+'/save', bookingDTO)
  }

  editBooking(bookingDTO: BookingDTO, bookingId: number): Observable<Booking>{
    return this.http.put<Booking>(this.apiUrl+'/edit/'+bookingId, bookingDTO)
  }

  deleteBooking(bookingId: number): Observable<Booking>{
    return this.http.delete<Booking>(this.apiUrl+'/del'+bookingId)
  }

  
   
}
