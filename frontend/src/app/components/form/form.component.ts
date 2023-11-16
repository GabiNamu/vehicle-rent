import { VehicleService } from './../../services/vehicle.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent {
  vehicleForm!: FormGroup

  constructor(private vehicleService: VehicleService, private router: Router) {}

  ngOnInit(): void {
    this.vehicleForm = new FormGroup({
      brand: new FormControl('', [Validators.required]),
      model: new FormControl('', [Validators.required]),
      color: new FormControl('', [Validators.required]),
      manufacturing_year: new FormControl(0, [Validators.required]),
      license_plate: new FormControl('', [Validators.required]),
    })
  }

  get brand() {
    return this.vehicleForm.get('brand')!;
  }

  get model() {
    return this.vehicleForm.get('model')!;
  }

  get color() {
    return this.vehicleForm.get('color')!;
  }

  get manufacturingYear() {
    return this.vehicleForm.get('manufacturing_year')!;
  }

  get licensePlate() {
    return this.vehicleForm.get('license_plate');
  }

  submit() {
    if (this.vehicleForm.invalid) {
      return;
    }

    this.vehicleService.insert(this.vehicleForm.value).subscribe();
    this.router.navigate(['/']);
  }
}
