import { Component, Input, OnInit } from '@angular/core';
import { Order } from '../order';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
})
export class OrderComponent {

  customerOrders : Order[];

    @Input()
    salesRepId! : string;

    constructor(){
        this.customerOrders = [new Order("O101",new Date("10/07/2021"),"S01"),
        new Order("O102",new Date("11/07/2021"),"S02"),
        new Order("O103",new Date("12/07/2021"),"S02"),
        new Order("O104",new Date("10/07/2021"),"S03"),
        new Order("O104",new Date("07/07/2021"),"S01"),
        new Order("O105",new Date("09/07/2021"),"S02"),
        new Order("O106",new Date("11/07/2021"),"S03"),
        new Order("O107",new Date("10/07/2021"),"S01"),
        new Order("O108",new Date("10/07/2021"),"S02"),
        new Order("O109",new Date("10/07/2021"),"S02")];
    }

}
