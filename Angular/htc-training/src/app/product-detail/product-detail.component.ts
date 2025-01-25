import { Component, OnInit } from '@angular/core';
import { ProductMaster } from '../product-master';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  productMaster!:ProductMaster;
  constructor() { }

  productList(){

  }

  ngOnInit(): void {
    this.productMaster = new ProductMaster(1,' Wire Strippers',' Hand tools','Keeper and repair tools',120,350,2500,'At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos.');
  }

}
