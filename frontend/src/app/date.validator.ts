import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class DateValidator {
  static futureDate(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const selectedDate = new Date(control.value);
      const currentDate = new Date();

      if (selectedDate < currentDate) {
        return { futureDate: true };
      }

      return null;
    };
  }

  static finalDate(inicialDate: Date): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const selectedDate = new Date(control.value);
      const inicalDate = inicialDate;

      if (selectedDate < inicalDate) {
        return { finalDate: true };
      }

      return null; 
    }
  }
}
