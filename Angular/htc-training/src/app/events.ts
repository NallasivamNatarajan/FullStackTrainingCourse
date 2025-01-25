import { DatePipe } from '../../node_modules/@angular/common';

export class Events {
    eventName!:string;
    participantName!:string;
    address!:string;
    email!:string;
    contactNo!:number;
    manufactureDate!:Date;

    constructor(eventName:string, participantName:string, 
        address:string, email:string, contactNo:number, manufactureDate:Date){
        this.eventName = eventName;
        this.participantName = participantName;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
        this.manufactureDate = manufactureDate;
    }
}
