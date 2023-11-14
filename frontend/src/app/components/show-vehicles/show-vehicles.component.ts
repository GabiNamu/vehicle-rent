import { Vehicle } from './../../Vehicle';
import { VehicleService } from './../../services/vehicle.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-show-vehicles',
  templateUrl: './show-vehicles.component.html',
  styleUrls: ['./show-vehicles.component.scss']
})
export class ShowVehiclesComponent {
  vehicles: Vehicle[] = [];
  
  constructor(private vehicleService: VehicleService) {
    this.getVehicles();
  }

  ngOnInit(): void {}
  
  getVehicles(): void {
    this.vehicleService.getAll().subscribe((vehicles) => (this.vehicles = vehicles));
  }

  removeVehicle(vehicle: Vehicle){
    if (!vehicle.reserved) {
      this.vehicles = this.vehicles.filter((a) => vehicle !== a);
      this.vehicleService.remove(vehicle.id).subscribe();
    }
  }

  reserveVehicle(vehicle: Vehicle) {
    this.vehicles = this.vehicles.filter((a) => vehicle !== a);
    this.vehicleService.reserve(vehicle.id, vehicle).subscribe((vehicle) => (this.vehicles.push(vehicle)));
  }
  
}
