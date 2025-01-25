import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IProduct } from './iproduct';
import {Observable} from 'rxjs';
import { AllOrderDetails } from './all-order-details';
import { IOrderCounts } from './IOrderCounts';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {

  private baseUrl = 'http://localhost:8081/material-management/my-orders/OrderDetails';  
  private url ='http://localhost:8081/material-management/my-orders/OrderDetails/';
  private deleteUrl='http://localhost:8081/material-management/my-orders/deleteOrderData/';
  private statusUpdateUrl='http://localhost:8081/material-management/my-orders/updateOrder/';
  private ordersCountUrl='http://localhost:8081/material-management/my-orders/orderCount';
  dataUrl='./assets/data/cartData.json';

  constructor(private http:HttpClient) { }
  
  getOrderList():Observable<any>
  {
    return this.http.get(this.baseUrl);
  }

  getOrder(orderId:number): Observable<any>{
    return this.http.get(`${this.url}${orderId}`);
  }

  getProductsData(){
    return this.http.get<IProduct[]>(this.dataUrl);
  }

  deleteOrderDetails(orderId:number){
    return this.http.delete(`${this.deleteUrl}${orderId}`);
  }

  rejectOrderDetails(orderId:number,orderStatusId:number,comment:string){
   return this.http.post<any>(`${this.statusUpdateUrl}${orderId}/${orderStatusId}/${comment}`,null);
  }
  
  approveOrderDetails(orderId:number,orderStatusId:number,comment:string){
  
    return this.http.post(`${this.statusUpdateUrl}${orderId}/${orderStatusId}/${comment}`,null);
  }

  getOrderCountDetails():Observable<IOrderCounts>{
    return this.http.get<IOrderCounts>(this.ordersCountUrl);
  }

}
