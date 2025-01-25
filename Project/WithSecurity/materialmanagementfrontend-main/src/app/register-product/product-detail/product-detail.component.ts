import { Component, OnInit } from '@angular/core';
import { ProductMaster } from '../product-master';
import { ProductRequestService } from '../../service/product-request.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  productMaster!:ProductMaster;
  productId!:number;
  imageLocalPath!:string;
  constructor(private productService : ProductRequestService,
    private route: ActivatedRoute,
    private router: Router) {
    this.imageLocalPath = "./assets/img/";
     }

  productList(){

  }

  ngOnInit(): void {

    this.productId = this.route.snapshot.params['productId'];
    
    this.productService.getProductDetail(this.productId).subscribe(data => {
      console.log(data)
      this.productMaster = data;
      var imagePath = data.imageUrl;
      if(imagePath){
        var image = imagePath.substring(12,imagePath.length);
        data.imageUrl = `${this.imageLocalPath+image}`;
        console.log(data.imageUrl);
      }
    }, error => console.log(error))
   
  }

}
