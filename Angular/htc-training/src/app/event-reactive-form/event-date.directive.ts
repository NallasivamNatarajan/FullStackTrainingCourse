import { Directive } from '@angular/core';

import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[appEventDate]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: EventDateDirective,
    multi: true
  }]
})

export class EventDateDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    if (control.value) {
      let currentDate = new Date().toISOString().substring(0,10);
      if (control.value < currentDate) {
        return { "appEventDate": true }
      }
    }
    return null;
  }
}
