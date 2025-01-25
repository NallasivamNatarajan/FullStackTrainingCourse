import { Component, OnInit } from '@angular/core';
import { IProduct } from '../iproduct';
import { OrderserviceService } from '../orderservice.service';
import Swal from 'sweetalert2';
import { ICart } from '../icart';
import { Router } from '@angular/router';
import { ProductRequestService } from '../service/product-request.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  productsData: IProduct[] = [] as IProduct[];
  quantity: number = 0;
  cartData: ICart[] = [] as ICart[];
  cart:ICart={
    productId:0,
    quantity:0
  };
  userdata:any={
    id:'',
    role: '',
  }

  constructor(private orderService: OrderserviceService,private productService:ProductRequestService, private router: Router) {}

  ngOnInit(): void {
    this.productsData=JSON.parse(localStorage.getItem("cartProducts") || '{}');
    this.userdata = JSON.parse(localStorage.getItem('userData') || '{}');
  }

  dec(product: IProduct) {
    product.quantity = product.quantity <= 1 ? 1 : product.quantity - 1;
  }

  inc(product: IProduct) {
    product.quantity = product.quantity + 1;
  }

  deleteItemCart(product: IProduct) {
     this.removeById(this.productsData,product.productId);

     localStorage.setItem(
      'cartProducts',
      JSON.stringify(this.productsData)
    );
    Swal.fire(
      'Removed Successfully',
      'Product with Id ' + product.productId + ' has been removed from cart',
      'error'
    );
  }

  placeOrders(productsData: IProduct[]) {
    this.productService.placeOrder(this.userdata.id,productsData).subscribe((data:any) => {
      console.log(data);
         }, error => console.log(error));
    if(productsData.length>0){
    localStorage.setItem('cartProducts', '{}');
    Swal.fire('Success', 'Your Order has been placed Successfully.', 'success').then(() => {
          window.location.reload();
        });
    this.reloadCurrentRoute();
  }
  else{
    Swal.fire(
      'Cart is Empty',
      'Please add the products to the Cart',
      'error'
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

  reloadCurrentRoute() {
    this.router.navigateByUrl('/', {skipLocationChange: false}).then(() => {
        this.router.navigate(['/home/my-orders']);
    });
}

}
