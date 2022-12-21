import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {

  devicetype: any[] = [
    {name:'SMARTPHONE'},
    {name:'AMPLIFIER'},
    {name:'HEADPHONE'},
    {name:'HI_FI'},
    {name:'ELECTRONICS'},
    {name:'HOUSEHOLD_APPLIANCE'},
	  {name:'TV'},
	  {name:'LAPTOP'},
	  {name:'DESKTOP'},
	  {name:'OTHER'}
  ]

  form!: FormGroup;

  constructor(private auth: AuthService) { }

  ngOnInit(): void {
    this.form = new FormGroup({
      model: new FormControl(null, [Validators.required]),
      devicetype: new FormControl(null, [Validators.required]),
      serialnumber: new FormControl(null, [Validators.required]),      
      bookingDate: new FormControl(null, [Validators.required])
    })

    // this.auth.isUserLogged();
  }

  submitBooking(): void {}

}
