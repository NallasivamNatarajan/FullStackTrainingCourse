export class ParticipantList {
    participantName:string;
    email:string;
    eventCode:string;

    constructor(participantName:string,email:string,eventCode:string){
        this.participantName=participantName;
        this.email=email;
        this.eventCode=eventCode;
    }
}

