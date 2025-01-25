import { Component, OnInit } from '@angular/core';
import { EventList } from '../event-list';

@Component({
  selector: 'app-event-parent',
  templateUrl: './event-parent.component.html',
  styleUrls: ['./event-parent.component.css']
})
export class EventParentComponent {
  events : EventList[];
  eventId !: string;
  constructor() { 
    this.events = [new EventList('E01','Dancing'),
    new EventList('E02','Painting'),
    new EventList('E03','Quiz'),
    new EventList('E04','Cooking')]
   }

   onEventIdSelect(event:EventList):void{
     this.eventId = event.eventId;
   }

}
