import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[appEvent]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: EventDirective,
    multi: true
  }]
})
export class EventDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    if (control.value){
      if (control.value == '--choose--') {
        return { 'appEvent': true };
      }
    }
    return null;
  }

}
