import { Component, OnInit } from '@angular/core';
import { IProduct } from '../iproduct';
import Swal from 'sweetalert2';
import { ProductRequestService } from '../service/product-request.service';
import { Router } from '@angular/router';
import { Category } from '../category';
import { LineNumber } from '../line-number';
import { IDropDownValues } from '../IDropDownValues';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.css']
})
export class PlaceOrderComponent implements OnInit {
  productsData: IProduct[] = [] as IProduct[];
  selectedProducts: IProduct[] = [] as IProduct[];
  cartExistingProducts: IProduct[] = [] as IProduct[];
  categorySearch: string = 'Accessories';
  productNameSearch!: string;
  lineNumber: string = 'Line 01';
  imageLocalPath!: string;
  categories: string[] = [] as string[];
  lineNumbers: string[] = [] as string[];
  categoryList!: Category[];
  lineNumbersList!: LineNumber[];
  dropDownListData!: IDropDownValues;

  constructor(private productservice: ProductRequestService, private router: Router) {
    this.imageLocalPath = "./assets/img/";
  }

  ngOnInit(): void {
    this.productservice.getProductList().subscribe((data: any) => {
      this.productsData = data;
      this.productsData.map(item => {
        var imagePath = item.imageUrl;
        if (imagePath) {
          var image = imagePath.substring(12, imagePath.length);
          item.imageUrl = `${this.imageLocalPath + image}`;
          console.log(item.imageUrl);
        }
      })

    });
    this.productservice.getDropDownValues().subscribe((data) => {
      // this.categories = data.categories;
      // this.lineNumbers = data.lineNumbers;
      this.dropDownListData = data;
      this.lineNumbersList = this.dropDownListData.lineNumberList; 
      this.categoryList = this.dropDownListData.categoryList;
    });
  }

  checkBoxClicked(event: any, products: IProduct) {
    if (event.target.checked) {
      this.selectedProducts.push(products);
    }
    if (!event.target.checked) {
      this.removeById(this.selectedProducts, products.productId);
      localStorage.setItem(
        'cartProducts',
        JSON.stringify(this.selectedProducts)
      );
    }
  }

  removeById(arr: IProduct[], id: number) {
    const requiredIndex = arr.findIndex((el) => {
      return el.productId === id;
    });
    if (requiredIndex === -1) {
      return false;
    }
    return !!arr.splice(requiredIndex, 1);
  }

  addProductsToCart() {
    if (this.selectedProducts.length > 0) {
      this.cartExistingProducts = JSON.parse(localStorage.getItem("cartProducts") || '{}');
      if (this.cartExistingProducts.length > 0) {
          this.selectedProducts.forEach(sp => {
              this.cartExistingProducts.push(sp);
          })       
          this.selectedProducts = this.cartExistingProducts.filter(
            (thing, i, arr) => arr.findIndex(t => t.productId === thing.productId) === i
          );
      }
      localStorage.setItem(
        'cartProducts',
        JSON.stringify(this.selectedProducts)
      );
      Swal.fire('Added Successfully', '', 'success');
      this.reloadCurrentRoute();
    } else {
      Swal.fire('Please select the Product', '', 'error');
    }
  }

  reloadCurrentRoute() {
    let currentUrl = this.router.url;
    this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
      this.router.navigate([currentUrl]);
    });
  }
}
