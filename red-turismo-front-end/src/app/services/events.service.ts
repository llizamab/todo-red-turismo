import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
//import { of } from 'rxjs/observable/of';

@Injectable()
export class EventsService {

  private servUrl = 'http://localhost:9001/xxx';
  private findAll = this.servUrl + '/findAll';
  private findById = this.servUrl + '/findById?id=';
  
  constructor(private http: HttpClient) { 
  
  }

  getAllGiftCards(): Observable<any[]> {
    return this.http.get<any[]>(this.findAll);
  }
  
  getGiftCardById(id: string): Observable<any> {
    return this.http.get<any>(this.findById + id);
  }
}