import { Component, OnInit } from '@angular/core';
import { OrderSummary } from '../order-summary';
import { OrderserviceService } from '../orderservice.service';
import { Router, ActivatedRoute } from '../../../node_modules/@angular/router';
import { IProduct } from '../iproduct';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-my-orders-summary',
  templateUrl: './my-orders-summary.component.html',
  styleUrls: ['./my-orders-summary.component.css']
})
export class MyOrdersSummaryComponent implements OnInit {

  orderData!:IProduct[];
  orderId!: number;
  orderSummary!: OrderSummary;
  orderNum !: string;
  public counts = ["Pending","S.I Rejected","S.I Approved","Admin Rejected","Received"];
  public orderStatus!:string;
  shiftInchargeComment!: string;
  adminComment!:string;

  constructor(private orderService:OrderserviceService,private route: ActivatedRoute,private router: Router) { 


  }

  ngOnInit(): void {
    this.orderId = this.route.snapshot.params['orderId'];

    this.orderService.getOrder(this.orderId)
    .subscribe((data:any) => {
      this.orderSummary = data;
      this.orderNum = this.orderSummary.orderNumber;
      this.orderData= this.orderSummary.cartData;
      this.orderStatus =this.orderSummary.orderStatus;
      this.shiftInchargeComment=this.orderSummary.shiftInchargeComments;
      this.adminComment=this.orderSummary.adminComments;
    });
   

}

deletOrderDetails(orderId:number){
  this.orderService.deleteOrderDetails(orderId).subscribe((data:any) => {
    console.log(data);
       }, error => console.log(error));
  Swal.fire('Order Cancelled', 'Your Order has been Cancelled', 'success').then(() => {
        window.location.reload();
      });
 
  this.router.navigate(['/home/my-orders']);

}
}

