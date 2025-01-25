import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProductMaster } from '../register-product/product-master';
import { Observable } from 'rxjs';
import { IDropDownValues } from '../IDropDownValues';
import { IProduct } from '../iproduct';


@Injectable({
  providedIn: 'root'
})
export class ProductRequestService {

  productMaster?:ProductMaster;
  private baseUrl = 'http://localhost:8081/material-management';
  private addProductUrl = '/product/addProduct';
  private productList = '/product/getProducts';
  private productDetailsUrl = '/product/getProduct';
  private placeOrderUrl='/myOrders/'
  private placeOrderUrl2='/placeOrder';
  // requestHeader = new HttpHeaders({ 'Authorization': 'Bearer '+ localStorage.getItem('jwtToken')});
  constructor(private httpClient:HttpClient) { }

  saveProduct(productMaster : ProductMaster){
    return this.httpClient.post<ProductMaster>(`${this.baseUrl+this.addProductUrl}`, productMaster);
  }

  getProductList():Observable<any>{
    return this.httpClient.get(`${this.baseUrl+this.productList}`);
    // ,{
    //   headers : this.requestHeader,
    //  });
  }

  getProductDetail(productId:number): Observable<any>{
    return this.httpClient.get(`${this.baseUrl+this.productDetailsUrl}/${productId}`);
  }

  getProductMaster(productId: number){
    return this.httpClient.get(`http://localhost:8080/productRequest`);
  }

  getDropDownValues():Observable<IDropDownValues>{
    return this.httpClient.get<IDropDownValues>('http://localhost:8081/material-management/myOrders/getAllDropdownList');
  }

  placeOrder(userId:number,products : IProduct[]){
    return this.httpClient.post<IProduct[]>(`${this.baseUrl+this.placeOrderUrl}${userId}${this.placeOrderUrl2}`, products);
  }

}
