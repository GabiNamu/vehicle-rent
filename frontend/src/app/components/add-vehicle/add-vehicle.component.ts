import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
})
export class AddVehicleComponent {
  constructor(private router: Router) {}

  redirect() {
    this.router.navigate(['/add']);
  }
}
