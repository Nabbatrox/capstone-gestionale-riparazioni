import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookingRoutingModule } from './booking-routing.module';
import { BookingComponent } from './booking.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ForecastComponent } from 'src/app/components/forecast/forecast.component';


@NgModule({
  declarations: [
    BookingComponent,
    ForecastComponent
  ],
  imports: [
    CommonModule,
    BookingRoutingModule,
    ReactiveFormsModule,
    FormsModule
    
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class BookingModule { }
