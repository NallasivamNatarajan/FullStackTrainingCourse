import { Component, OnInit } from '@angular/core';
import { ProductRequestService } from '../product-request.service';
import { ProductMaster } from '../product-master';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {
 
  productMasterList!:ProductMaster[];
  title!: string;

  constructor(private productServie:ProductRequestService) { 
    this.productMasterList = [
      new ProductMaster(1,'AA','ssa','asd',0,0,0,'dsasd'),
      new ProductMaster(2,'BB','asd','dsa',0,0,0,'asdfasd'),
      new ProductMaster(3,'CC','asdf','gasd',0,0,0,'sadfas'),
    ]
    this.title = "New Product Request";
  }

  ngOnInit(): void {
   // this.getProductList();

  }

  getProductList(){
  this.productServie.getProductList().subscribe((data:any) =>{
    this.productMasterList = data;
  }); 

}

}
