import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-event-reactive-form',
  templateUrl: './event-reactive-form.component.html',
  styleUrls: ['./event-reactive-form.component.css']
})
export class EventReactiveFormComponent {


  eventReactiveForm!: FormGroup;
  eventList!: string[];
  title!: string;
  //  name=new FormControl('Basha');

  constructor(private formBuilder: FormBuilder) {
    this.eventReactiveForm = this.createReactiveForm();
    this.eventList = ["--choose--", "dance", "speech", "sing", "game"];
    this.title = "Reactive Form";
  }

  // updateName(){
  //   this.name.setValue('Maanick Bashaaaa');
  // }

  // createReactiveForm(): FormGroup {
  //   return this.formBuilder.group({
  //     eventNames: new FormControl('', Validators.compose([Validators.required,chooseEvent])),
  //     participantName: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(20)])),
  //     address: new FormControl(''),
  //     contactNo: new FormControl('', Validators.compose([Validators.minLength(10), Validators.maxLength(15)])),
  //     email: new FormControl('', Validators.compose([Validators.required, Validators.minLength(7), Validators.maxLength(20)])),
  //     eventDate: new FormControl(new Date(),validateEventDate),
  //     gender: new FormControl('male', Validators.compose([Validators.required,validateEventDate]))
  //   });
  // }

  createReactiveForm(): FormGroup {
    return this.formBuilder.group({
      eventNames: new FormControl('',Validators.required),
      participantName: new FormControl('', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(20)])),
      address: new FormControl('', Validators.required),
      contactNo: new FormControl('', Validators.compose([Validators.required,Validators.minLength(10), Validators.maxLength(15)])),
      email: new FormControl('', Validators.compose([Validators.required, Validators.minLength(7), Validators.maxLength(20)])),
      eventDate: new FormControl(new Date(), Validators.required),
      gender: new FormControl('male', Validators.required)
    },{validator:validateForm});
  }

  reset() {
    this.eventReactiveForm.reset();
  }
}

export function chooseEvent(control: AbstractControl): ValidationErrors | null {
  if (control.value == '--choose--' || control.value == '') {
    return { "validEvent": true }
  }
  return null;
}

export function validateEventDate(control: AbstractControl): ValidationErrors | null {
  if (control.value) {
    let currentDate = new Date().toISOString().substring(0,10);
    if (control.value < currentDate) {
      return { "validateDate": true }
    }
  }
  return null;
}


//cross-field validation
function validateForm(control: FormGroup): ValidationErrors | null {

  if (control.value.eventNames == '--choose--') {
    return { "validEvent": true };
  }
  if (control.value.eventDate) {
    let currentDate = new Date().toISOString().substring(0,10);
    let checkDate = control.value.eventDate;
    if (checkDate < currentDate) {
      return { "validateDate": true }
    }
  }

  return null;
}