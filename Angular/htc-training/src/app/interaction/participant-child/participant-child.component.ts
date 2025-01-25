import { Component, OnInit, Input } from '@angular/core';
import { ParticipantList } from '../participant-list';
import { ParticipantJsonService } from '../participant-json.service';

interface ParticipantJson{
  participantName:string;
  email:string;
  eventCode:string;
}

@Component({
  selector: 'app-participant-child',
  templateUrl: './participant-child.component.html',
  styleUrls: ['./participant-child.component.css']
})
export class ParticipantChildComponent {

   participants !: ParticipantList[];

  @Input()
  eventId!: string;

  constructor(private participantService: ParticipantJsonService){
    // this.participants  = ParticipantJson.json;

this.participants = [new ParticipantList('Nallasivam','nallas@gmail.com','E01'),
new ParticipantList('Siva','nallas@gmail.com','E01'),
new ParticipantList('Karthi','nallas@gmail.com','E02'),
new ParticipantList('Satheesh','nallas@gmail.com','E01'),
new ParticipantList('Babu','nallas@gmail.com','E01'),
new ParticipantList('Hari','nallas@gmail.com','E03'),
new ParticipantList('Nallasivam','nallas@gmail.com','E02'),
new ParticipantList('Babu','nallas@gmail.com','E01'),
new ParticipantList('Nallasivam','nallas@gmail.com','E03'),
new ParticipantList('Siva','nallas@gmail.com','E04'),
new ParticipantList('karthi','nallas@gmail.com','E01'),
new ParticipantList('ashok','nallas@gmail.com','E02'),
new ParticipantList('mohan','nallas@gmail.com','E03'),
new ParticipantList('ranjith','nallas@gmail.com','E04'),
new ParticipantList('sujai','nallas@gmail.com','E02')
]


  }


}
