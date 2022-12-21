import { Component, OnInit } from '@angular/core';
import { ForecastService } from 'src/app/forecast.service';
import { ForecastData } from 'src/app/models/forecast-data';
import { ForecastDetails } from 'src/app/models/forecast-details';
import { WeatherData } from 'src/app/models/weather-data';

@Component({
  selector: 'app-forecast',
  templateUrl: './forecast.component.html',
  styleUrls: ['./forecast.component.scss']
})
export class ForecastComponent implements OnInit {
  zip!: number;
  listFilter: any;
  showCurrent: boolean = false;
  showForecast: boolean = false;
  weatherDetails: WeatherData = new WeatherData();
  forecastData: ForecastData = new ForecastData;

  constructor(private forecastService: ForecastService) { }

  ngOnInit(): void {
  }

  loadForecastWeather() {
    this.forecastService.LoadForecastWeather(this.zip).subscribe(
   res => {
            this.forecastData = new ForecastData();//Instance to store the Data of ForecastModel
            this.forecastData.name = res.city.name;
        for(var i=7; i<res.list.length;i=i+8)//Since we want for 5 days. it Jumps 8 times to get to next day.(A day had 8 details in API.)
        {
          //Instance of type ForecastDetails and stores the data in it.
          var details = new ForecastDetails();
              details.date = res.list[i].dt_txt;
              details.maxTemperature = res.list[i].main.temp_max;
              details.minTemperature = res.list[i].main.temp_min;
              details.description = res.list[i].weather[0].description;
              details.icon = res.list[i].weather[0].icon;
              this.forecastData.details.push(details);//Pushing the data to the to created object

        }
        this.showCurrent = false;
        this.showForecast = true;
   }
 )
}
loadCurrentWeather() {
  this.forecastService.LoadCurrentWeather(this.zip).subscribe(
 res => {
      this.weatherDetails.cityName = res.name;
      this.weatherDetails.description = res.weather[0].description;
      this.weatherDetails.currentTemperature=   res.main.temp;
      this.weatherDetails.icon = res.weather[0].icon;
      this.weatherDetails.maxTemperature=res.main.temp_max;
      this.weatherDetails.minTemperature = res.main.temp_min;
      this.showCurrent = true;
      this.showForecast = false;
 }
)
}

}
