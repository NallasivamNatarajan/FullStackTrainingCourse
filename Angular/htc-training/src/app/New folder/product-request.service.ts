import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ProductMaster } from './product-master';
//import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductRequestService {

  productMaster?:ProductMaster;
  productReqUrl!:'http://localhost:8080/productRequest';
  constructor(private httpClient:HttpClient) { }

  saveProduct(productMaster : ProductMaster){
    return this.httpClient.post<ProductMaster>(this.productReqUrl, productMaster);
  }

  getProductList(){
    return this.httpClient.get('http://localhost:8080/productRequest');
  }

  getProductMaster(productId: number){
    return this.httpClient.get(`http://localhost:8080/productRequest`);
  }

}
