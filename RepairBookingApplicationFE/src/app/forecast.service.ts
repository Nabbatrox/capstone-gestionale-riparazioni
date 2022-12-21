import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForecastService {

  apiKey: string = "fb39763a0932f87377c3b4660b1f6fe5"

  constructor(private http: HttpClient) { }

  LoadForecastWeather(zip: any): Observable<any> {
    return this.http.get("https://api.openweathermap.org/data/2.5/forecast?zip="+zip+",it&APPID="+this.apiKey+"&units=imperial" );
  }

  LoadCurrentWeather(zip: any): Observable<any> {
    return this.http.get("https://api.openweathermap.org/data/2.5/weather?zip="+zip+",it&APPID="+this.apiKey+"&units=imperial" );
  }
}
