import { Component, OnInit, ViewChild } from '@angular/core';
import { NgbCarousel, NgbCarouselModule, NgbSlideEvent, NgbSlideEventSource } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';

@Component({
	selector: 'ngbd-carousel-basic',
	standalone: true,
	imports: [NgbCarouselModule, FormsModule],
	templateUrl: './carousel.component.html',
})
export class CarouselComponent implements OnInit{
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  
}
