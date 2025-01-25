import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ParticipantList } from './participant-list';

@Injectable({
  providedIn: 'root'
})
export class ParticipantJsonService {
  participants !: ParticipantList[];

  constructor(private httpClient: HttpClient) {
   }

  getAllParticipants(){
    // this.participants =  this.httpClient.get("assets/participant.json").subscribe((res:any)=>{
    //   this.participants = res;
      return this.participants;
  // })
    
  }
}