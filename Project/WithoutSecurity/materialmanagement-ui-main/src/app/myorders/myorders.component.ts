import { HttpClient } from '@angular/common/http';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';

import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { OrderDetails } from '../order-details';
import { OrderserviceService } from '../orderservice.service';
import { Router } from '../../../node_modules/@angular/router';
import { AllOrderDetails } from '../all-order-details';

@Component({
  selector: 'app-myorders',
  templateUrl: './myorders.component.html',
  styleUrls: ['./myorders.component.css']
})
export class MyordersComponent implements OnInit {
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) matpaginator!: MatPaginator;
  @ViewChild('paginator') paginator!: MatPaginator;

  orders!:AllOrderDetails[];
  p: number = 1;
  q: number = 1;
  r: number = 1;
  
  constructor(private orderService:OrderserviceService,private http:HttpClient,private router:Router) { 
   
  }

  ngOnInit(){
    this.orderService.getOrderList()
    .subscribe((data:any) => {
      this.orders = data;
    });
  }

  

  displayedColumns: string[] = ['orderCode', 'requestBy','requestDepartment', 'requestSection','orderType', 'requestedOn','status'];

 
  getOrderDetail(orderId:number){
    this.router.navigate(['home/my-orders-summary',orderId]);
  }


}

