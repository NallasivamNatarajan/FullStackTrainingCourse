import { Component, OnInit } from '@angular/core';
import { EventForm } from '../event-form';

@Component({
  selector: 'app-event-template-form',
  templateUrl: './event-template-form.component.html',
  styleUrls: ['./event-template-form.component.css']
})
export class EventTemplateFormComponent {
  eventModel !: EventForm;
  eventNamesList !: string[];
  title !: string;
  constructor() { 
    this.eventModel = new EventForm();
    this.eventNamesList = ['--choose--','dance', 'speech', 'sing', 'game'];
    this.title = "Template Driven Form";
  }

}
