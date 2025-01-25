import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { AllOrderDetails } from '../all-order-details';
import { OrderserviceService } from '../orderservice.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {
  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) matpaginator!: MatPaginator;
  @ViewChild('paginator') paginator!: MatPaginator;

  orders!:AllOrderDetails[];
  p: number=1;
  constructor(private orderService:OrderserviceService,private http:HttpClient,private router:Router) { 
    this.orderService.getOrderList()
    .subscribe((data:any) => {
      this.orders = data;
    });

  }
  ngOnInit(){
    
  }

  displayedColumns: string[] = ['orderCode', 'requestBy','requestDepartment', 'requestSection','orderType', 'requestedOn','status'];

 
  getOrderDetail(orderId:number){
    this.router.navigate(['home/admin-list-summary',orderId]);
  }

}