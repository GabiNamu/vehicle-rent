import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle } from '../Vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAll(): Observable<Vehicle[]> {
    return this.http.get<Vehicle[]>(this.apiUrl);
  }

  remove(id: number) {
    return this.http.delete<Vehicle>(`${this.apiUrl}/${id}`);
  }

  reserve(id: number, vehicle: Vehicle) {
    console.log("entrei aqui")
    return this.http.put<Vehicle>(`${this.apiUrl}/${id}`, vehicle);
  }
  
}
