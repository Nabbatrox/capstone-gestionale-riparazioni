import { Component, OnInit } from '@angular/core';
import { BookingService } from 'src/app/booking.service';
import { Booking } from 'src/app/models/booking';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private booking: BookingService) { }
  private bookings: Booking[] = [];
  ngOnInit(): void {

    // this.booking.getAllBookings().subscribe(bookings => {this.bookings = bookings
    // console.log(this.bookings)
    // });

  }

}
