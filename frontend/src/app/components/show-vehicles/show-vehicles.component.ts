import { ActivatedRoute, Router } from '@angular/router';
import { Vehicle } from './../../Vehicle';
import { VehicleService } from './../../services/vehicle.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-show-vehicles',
  templateUrl: './show-vehicles.component.html'
})
export class ShowVehiclesComponent {
  vehicles: Vehicle[] = [];
  vehicle!: Vehicle;
  modal: boolean = false;
  
  constructor(
    private vehicleService: VehicleService,
    private route: ActivatedRoute,
    private router: Router) {
      this.getVehicles();
  }

  ngOnInit(): void {
    this.getVehicles();

    this.route.url.subscribe(() => {
      if (this.router.url === '/') {
        this.getVehicles();
      }
    });
  }
  
  getVehicles(): void {
    this.vehicleService.getAll().subscribe((vehicles) => (this.vehicles = vehicles));
  }

  removeVehicle(vehicle: Vehicle){
    if (vehicle.reserve == null) {
      this.vehicles = this.vehicles.filter((a) => vehicle !== a);
      this.vehicleService.remove(vehicle.id).subscribe();
    }
  }

  reserveVehicle(vehicle: Vehicle) {
    this.router.navigate(['/reservar', vehicle.id]);
  }

  removeReserve() {
    this.vehicleService.removeReserve(this.vehicle.id).subscribe();
    this.vehicles = this.vehicles.map((vehicle) => {
      if (vehicle.id === this.vehicle.id) {
        vehicle.reserve = null
      }
      return vehicle;
    });
  }

  openModal(vehicle: Vehicle) {
    this.modal = true;
    this.vehicle = vehicle;
  }

  closeModal() {
    this.modal = false;
  }

  filterReserved() {
    this.vehicleService.getAll().subscribe(
      (vehicles) => (this.vehicles = vehicles.filter((vehicle) => vehicle.reserve != null)));
  }

  filterNotReserved() {
    this.vehicleService.getAll().subscribe(
      (vehicles) => (this.vehicles = vehicles.filter((vehicle) => vehicle.reserve == null)));
  }
  
}
