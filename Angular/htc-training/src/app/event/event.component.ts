import { Component, OnInit } from '@angular/core';
import { Events } from '../events';
import { EventFilterPipe } from '../event-filter.pipe';
import { ApplicationServService } from '../application-serv.service';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: ['./event.component.css']
})
export class EventComponent {

  eventList!:Events[];
  evntName!:string;




  constructor() { 
    this.eventList = [
      new Events('dance','nallas','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('sing','nallas','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('speech','nallas','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('dance','roopan','Vellore','nsivam0@gmail.com',2387892372,  new Date(12/2/1996)),
      new Events('sing','siva','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('speech','karthi','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('dance','sathish','Vellore','nsivam0@gmail.com',2387892372,  new Date(12/2/1996)),
      new Events('game','hari','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('speech','lucky','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('dance','lucky','Vellore','nsivam0@gmail.com',2387892372,  new Date(12/2/1996)),
      new Events('sing','roopan','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('game','sivam','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('dance','nallas','Vellore','nsivam0@gmail.com',2387892372,  new Date(12/2/1996)),
      new Events('sing','karthi','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
      new Events('speech','sathish','Vellore','nsivam0@gmail.com',2387892372, new Date(12/2/1996)),
    ];

      // constructor(private productservice:ProductService){
  //   this.products = productservice.getProducts();
    
  // }

  // searchuser(){
    
  //   this.productservice.getUsers(this.id).subscribe((res:any)=>{
  //     this.users = res;
  //   })
  // }
    // this.appService
    
  }

 
}
