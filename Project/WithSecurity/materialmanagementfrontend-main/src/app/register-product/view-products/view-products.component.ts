import { Component, OnInit } from '@angular/core';

import { ProductMaster } from '../product-master';
import { ProductRequestService } from '../../service/product-request.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {
 
  productMasterList!:ProductMaster[];
  title!: string;
  productId!:number;
  imageLocalPath!:string;

  constructor(private productServie:ProductRequestService, private router: Router) { 
    // this.productMasterList = [
    //   new ProductMaster(1,'Wire Strippers','Hand tools','Keeper and Repair tool',120,350,1500,'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos.'),
    //   new ProductMaster(2,'Wire Strippers','Hand tools','Keeper and Repair tool',120,350,1500,'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos.'),
    //   new ProductMaster(3,'Wire Strippers','Hand tools','Keeper and Repair tool',120,350,1500,'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos.'),
    // ]
    this.title = "New Product Request";
    this.imageLocalPath = "./assets/img/";
  }

  ngOnInit(): void {
    this.getProductList();
  }

  getProductList(){
  this.productServie.getProductList().subscribe((data:any) =>{
    this.productMasterList = data;
    this.productMasterList.map(item => {
      var imagePath = item.imageUrl;
      if(imagePath){
        var image = imagePath.substring(12,imagePath.length);
        item.imageUrl = `${this.imageLocalPath+image}`;
        console.log(item.imageUrl);
      }
    })
  }); 
  }

getProductDetail(productId: number){
  this.router.navigate(['home/product-detail', productId]);
}

}