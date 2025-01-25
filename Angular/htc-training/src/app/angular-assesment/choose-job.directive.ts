import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[appChooseJob]',
  providers: [{
    provide: NG_VALIDATORS,
    useExisting: ChooseJobDirective,
    multi: true
  }]
})
export class ChooseJobDirective implements Validator {

  validate(control: AbstractControl): ValidationErrors | null {
    if (control.value){
      if (control.value == '--choose--') {
        return { 'appChooseJob': true };
      }
    }
    return null;
  }

}
