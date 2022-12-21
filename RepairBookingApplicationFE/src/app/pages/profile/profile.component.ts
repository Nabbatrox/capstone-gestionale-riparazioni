import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth.service';
import { BookingService } from 'src/app/booking.service';
import { Booking } from 'src/app/models/booking';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  constructor(private authSvc:AuthService, private route:Router, private bookingSvc: BookingService) { }

  user:User = this.authSvc.getLogged()
  bookings:Booking[] = [];

  ngOnInit(): void {
  }

  checkUserBookings(){
    
    this.bookingSvc.getAllBookingsByUserId(this.user.id).subscribe(res =>this.bookings = res )

  }

}
