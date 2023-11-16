import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Vehicle, addVehicle } from '../Vehicle';
import { AddReserve, Reserve } from '../Reserve';

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
    return this.http.put<Vehicle>(`${this.apiUrl}/${id}`, vehicle);
  }

  insert(vehicle: addVehicle) {
    return this.http.post<addVehicle>(this.apiUrl, vehicle);
  }

  insertReserve(vehicleId: number, reserve: AddReserve ) {
    return this.http.post<AddReserve>(`${this.apiUrl}/${vehicleId}/reserve`, reserve);
  }

  removeReserve(vehicleId: number) {
    return this.http.delete<Reserve>(`${this.apiUrl}/${vehicleId}/reserve`);
  }
  
}
