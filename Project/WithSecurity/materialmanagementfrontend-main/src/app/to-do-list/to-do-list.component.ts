import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { OrderserviceService } from '../orderservice.service';
import { AllOrderDetails } from '../all-order-details';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-to-do-list',
  templateUrl: './to-do-list.component.html',
  styleUrls: ['./to-do-list.component.css']
})
export class ToDoListComponent implements OnInit{
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) matpaginator!: MatPaginator;
  @ViewChild('paginator') paginator!: MatPaginator;

  orders!:AllOrderDetails[];
  p:number=1;
  
  constructor(private orderService:OrderserviceService,private http:HttpClient,private router:Router) { 

  }
  ngOnInit(){
    this.orderService.getToDoOrderList()
    .subscribe((data:any) => {
      this.orders = data;
    });

    // localStorage.getItem(use)
  }


  displayedColumns: string[] = ['orderCode', 'requestBy','requestDepartment', 'requestSection','orderType', 'requestedOn','status'];

 
  getOrderDetail(orderId:number){
    this.router.navigate(['home/to-do-item-summary',orderId]);
  }

}

