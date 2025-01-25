import { Component, OnInit } from '@angular/core';
import { Sales } from '../sales';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent {

  salesReps : Sales[];
    salesRepId! : string;

    constructor(){
        this.salesReps = [new Sales('S01',"Sam","Chennai"),
        new Sales('S02',"Ram","Bangalore"),
        new Sales('S03',"Ramu","Chennai"),];
    }

    onSalesRepIdSelected(salesRep:Sales):void{
        this.salesRepId = salesRep.salesRepId;
    }

}
