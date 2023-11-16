import { VehicleService } from './../../services/vehicle.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DateValidator } from 'src/app/date.validator';

@Component({
  selector: 'app-reserve',
  templateUrl: './reserve.component.html'
})
export class ReserveComponent {
  reserveForm!: FormGroup;
  vehicleId: number = 0;

  constructor(
    private vehicleService: VehicleService, 
    private route: ActivatedRoute, 
    private router: Router) {}

  ngOnInit(): void {
    this.reserveForm = new FormGroup({
      initial_date: new FormControl('', [Validators.required, DateValidator.futureDate()]),
      final_date: new FormControl('', [Validators.required, DateValidator.futureDate()]),
      name: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required, 
        Validators.maxLength(11), Validators.minLength(11), Validators.pattern('[0-9]*')]),
    })
    this.route.paramMap.subscribe(params => {
      this.vehicleId = +params.get('vehicleId')!;
    });
  }

  get initialDate() {
    return this.reserveForm.get('initial_date')!;
  }
  get finalDate() {
    return this.reserveForm.get('final_date')!;
  }
  get name() {
    return this.reserveForm.get('name')!;
  }
  get phone() {
    return this.reserveForm.get('phone')!;
  }

  submit() {
    if (this.reserveForm.invalid || this.initialDate.value > this.finalDate.value) {
      return;
    }

    this.vehicleService.insertReserve(this.vehicleId, this.reserveForm.value).subscribe();
    this.router.navigate(['/']);
  }
}
