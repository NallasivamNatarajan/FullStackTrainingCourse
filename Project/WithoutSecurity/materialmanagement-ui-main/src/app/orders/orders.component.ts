import { Component, OnInit } from '@angular/core';
import { IOrderCounts } from '../IOrderCounts';
import { OrderserviceService } from '../orderservice.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  ordersCount:IOrderCounts={
    approvedCount:0,
    pendingCount:0,
    rejectedCount:0,
    totalCount:0
  }
  constructor(private orderService:OrderserviceService) { }

  ngOnInit(): void {
    this.orderService.getOrderCountDetails().subscribe((data)=>{
      this.ordersCount=data;
    });
  }

}
